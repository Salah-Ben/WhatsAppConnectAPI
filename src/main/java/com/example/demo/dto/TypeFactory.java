package com.example.demo.dto;

import java.util.Arrays;
import java.util.List;

interface IVisitor1{
    boolean accept(WhatsAppMediaMessageRequestBody dto);
    void visit(WhatsAppMediaMessageRequestBody dto,String id);
}
public class TypeFactory {
    private static final List<IVisitor1> visitors1 = Arrays.asList(new ImageTypeVisitor(),new VideoTypeVisitor(),new AudioTypeVisitor(),new DocumentTypeVisitor(),new StickerTypeVisitor());
    public static void setType(WhatsAppMediaMessageRequestBody dto,String id){
        for (IVisitor1 visitor1: visitors1) {
            if(visitor1.accept(dto)){
                visitor1.visit(dto,id);
            }
        }
        //throw new IllegalArgumentException("Message of type "+ dto.getType()+" is not supported");
    }
}
class ImageTypeVisitor implements IVisitor1 {
    @Override
    public boolean accept(WhatsAppMediaMessageRequestBody dto) {
        return "image".equals(dto.getType());
    }
    @Override
    public void visit(WhatsAppMediaMessageRequestBody dto,String id) {
        dto.setImage(new Image(id));
    }
}
class VideoTypeVisitor implements IVisitor1 {
    @Override
    public boolean accept(WhatsAppMediaMessageRequestBody dto) {
        return "video".equals(dto.getType());
    }
    @Override
    public void visit(WhatsAppMediaMessageRequestBody dto,String id) {
        dto.setVideo(new Video(id));
    }
}
class AudioTypeVisitor implements IVisitor1 {
    @Override
    public boolean accept(WhatsAppMediaMessageRequestBody dto) {
        return "audio".equals(dto.getType());
    }
    @Override
    public void visit(WhatsAppMediaMessageRequestBody dto,String id) {
        dto.setAudio(new Audio(id));
    }
}
class DocumentTypeVisitor implements IVisitor1 {
    @Override
    public boolean accept(WhatsAppMediaMessageRequestBody dto) {
        return "document".equals(dto.getType());
    }
    @Override
    public void visit(WhatsAppMediaMessageRequestBody dto,String id) {
        dto.setDocument(new Document(id));
    }
}
class StickerTypeVisitor implements IVisitor1 {
    @Override
    public boolean accept(WhatsAppMediaMessageRequestBody dto) {
        return "sticker".equals(dto.getType());
    }
    @Override
    public void visit(WhatsAppMediaMessageRequestBody dto,String id) {
        dto.setSticker(new Sticker(id));
    }
}
