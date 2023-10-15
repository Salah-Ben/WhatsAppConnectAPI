package com.example.demo.dto;

public class MediaDto {
        private String caption;
        private String mimeType;
        private String sha256;
        private String id;
        private String text;
        private String longitude;
        private String latitude;
        private String address;
        private String name;
        private String emoji;
        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSha256() {
            return sha256;
        }

        public void setSha256(String sha256) {
            this.sha256 = sha256;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
                return text;
        }

        public String getLongitude() {
                return longitude;
        }
        public String getLatitude() {
            return latitude;
        }

        public String getAddress() {
                return address;
        }
        public String getName(){
                return name;
        }

        public String getEmoji() {
                return emoji;
        }
}
