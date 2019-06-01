package com.example.sw_1;

public class recycleviewfeed {
    private String mImageUrl;
        private String mplace;
        private String mspname;
        private int mrate;
        private String mtime;
        private String mdate;
        private String mcost;
        private String mdirection;
        private String mdiscrebtion;
        public recycleviewfeed(String imageUrl, String place, int rate) {
            mImageUrl = imageUrl;
            mplace = place;

            mrate =rate;
        }
        public recycleviewfeed(String imageUrl, String place, int rate,String spname) {
            mImageUrl = imageUrl;
            mplace = place;
            mspname=spname;
            mrate =rate;
        }
        /*public recycleviewfeed(String imageUrl, String place, int rate,String spname,String time,String date
                ,String cost,String direction,String discrebtion) {
            mImageUrl = imageUrl;
            mplace = place;
            mspname=spname;
            mrate =rate;
            mtime=time;
            mdate=date;
            mcost=cost;
            mdiscrebtion=discrebtion;
            mdirection = direction;
        }*/
        public String getspname() {
            return mspname;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public String getservice() {
            return mplace;
        }

        public int getrateCount() {
            return mrate;
        }
        public String gettime() {
            return mtime;
        }

        public String getdate() {
            return mdate;
        }

        public String getcost() {
            return mcost;
        }
        public String getdiscrebtion() {
            return mdiscrebtion;
        }
        public String getdirection() {
            return mdirection;
        }
}
