package com.example.Gads2020Project;

public class HoursData {
        public String name;
        public String hours;
        public String country;
        public String badgeUrl;

        public HoursData( String name, String hours, String country, String badgeUrl) {
            this.name = name;
            this.hours = hours;
            this.country = country;
            this.badgeUrl = badgeUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHours() {
            return hours;
        }

        public void setHours(String hours) {
            this.hours = hours;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getBadgUrl() {
            return badgeUrl;
        }

        public void setBadgUrl(String badgUrl) {
            this.badgeUrl = badgUrl;
        }


}
