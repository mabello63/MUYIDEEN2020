package com.example.Gads2020Project;

public class SkillsData {
        public String name;
        public String score;
        public String country;
        public String badgeUrl;

        public SkillsData(String name, String score, String country, String badgeUrl) {
            this.name = name;
            this.score = score;
            this.country = country;
            this.badgeUrl = badgeUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
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
