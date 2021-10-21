package ru.gb.lesson1;

import java.util.Random;

public class LessonOne {
    public static Random random = new Random();
    public static int maxLevel = 5;

    public static void main(String[] args) {
        Participant one = new Participant("Peter", 19);
        Participant two = new Participant("John", 20);
        Participant three = new Participant("Sue", 21);
        Participant four = new Participant("Bill", 25);
        Participant[] participantsList = {one, two, three, four};
        Team teamOne = new Team("team One", participantsList);
        Course course = new Course();
        course.doIt(teamOne);
    }

    public static class Team {
        String name;
        Participant[] participants;
        int teamLevel;
        public Team(String name, Participant[] participants) {
          this.name = name;
          this.participants = participants;
          this.teamLevel = setTeamLevel(participants);
        }

        private int setTeamLevel(Participant[] participants) {
            int buf = 0;
            for(Participant participant : participants) {
                buf = buf + participant.level;
            }
            return buf / participants.length;
        }

    }

    public static class Participant {
        String name;
        int age;
        int level;

        public Participant(String name, int age) {
            this.name = name;
            this.age = age;
            this.level = random.nextInt(maxLevel);
        }
    }

    public static class Course {
        int level;
        public Course() {
            this.level = random.nextInt(maxLevel);
        }

        public boolean doIt(Team team) {
            for (int i = 0; i < team.participants.length; i++) {
                if(team.participants[i].level >= level) {
                    System.out.println(team.participants[i].name + " passed the Course");
                } else {
                    System.out.println(team.participants[i].name + " failed the Course");
                }
            }
            if (this.level > team.teamLevel) {
                System.out.println("Team '" + team.name + "' failed the Course..");
                return false;
            } else {
                System.out.println("Team '" + team.name + "' won the Course!!");
                return true;
            }

        }

    }


}
