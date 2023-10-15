package com.example.demo.dto;

import java.util.Arrays;
import java.util.List;

interface IVisitor{
    boolean accept(MessageDTO dto);
    IMessage visit(MessageDTO dto);
}


public class MessageFactory {
    private static final List<IVisitor> visitors = Arrays.asList(new TextVisitor(),new DocumentVisitor(),new ImageVisitor(),new VideoVisitor(),new AudioVisitor(),new ButtonVisitor(),new StickerVisitor(),new LocationVisitor(),new ReactionVisitor());
    public static IMessage getMessage(MessageDTO dto){
        for (IVisitor visitor: visitors) {
            if(visitor.accept(dto)){
                return visitor.visit(dto);
            }
        }
        throw new IllegalArgumentException("Message of type "+ dto.getType()+" is not supported");
    }
}

class TextVisitor implements IVisitor{
    @Override
    public boolean accept(MessageDTO dto) {
        return "text".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new TextMessage(dto.getText().getBody());
    }
}

class ImageVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "image".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getImage().getId());
    }
}

class VideoVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "video".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getVideo().getId());
    }
}

class AudioVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "audio".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getAudio().getId());
    }
}

class DocumentVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "document".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getDocument().getId());
    }
}

class StickerVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "sticker".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getSticker().getId());
    }
}

class ButtonVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "button".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getButton().getId());
    }
}

class ReactionVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "reaction".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        return new MediaMessage(dto.getReaction().getEmoji());
    }
}

class LocationVisitor implements IVisitor {
    @Override
    public boolean accept(MessageDTO dto) {
        return "location".equals(dto.getType());
    }
    @Override
    public IMessage visit(MessageDTO dto) {
        String longitude = dto.getLocation().getLongitude();
        String latitude = dto.getLocation().getLatitude();
        String address = dto.getLocation().getAddress();
        String name = dto.getLocation().getName();
        return new MediaMessage(longitude,latitude,name,address);
    }
}



