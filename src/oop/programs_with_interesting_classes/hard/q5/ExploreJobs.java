package oop.programs_with_interesting_classes.hard.q5;

public class ExploreJobs {
    public static void main( String[] args )
    {
        JobAd a1 = new JobAd( "Programmer", 55000 );
        a1.addSkill( "programming" );
        a1.addSkill( "detailed oriented" );
        a1.addSkill( "hardworking" );

        JobAd a2 = new JobAd( "Blogger", 45000 );
        a2.addSkill( "writing" );
        a2.addSkill( "independence" );
        a2.addSkill( "time management" );

        JobAd a3 = new JobAd( "Programmer", 60000 );
        a3.addSkill( "web development" );
        a3.addSkill( "teamwork" );
        a3.addSkill( "programming" );
        a3.addSkill( "communication" );

        JobAd[] fullListing = { a1, a2, a3 };

        JobAd[] results;
        results = searchMinSalary( 50000, fullListing );
        System.out.println( "Results for jobs with at least 50000 salary..." );
        displaySearchResults( results );

        results = whichJobsRequire( "writing", fullListing );
        System.out.println( "Results for jobs that require writing..." );
        displaySearchResults( results );

        results = whichJobsRequire( "programming", fullListing );
        System.out.println( "Results for jobs that require programming..." );
        displaySearchResults( results );
    }
    public static void displaySearchResults( JobAd[] listing )  {
        for(int x = 0; x < listing.length; x++) {
            System.out.println("Job Ad " + (x + 1) + ":");
            System.out.println(listing[x].toString());
        }
    }
    public static JobAd[] searchMinSalary( int min, JobAd[] listing ) {
        int count = 0;
        for (JobAd ad : listing) {
            if (ad.getSalary() >= min) {
                count++;
            }
        }
        JobAd[] newList = new JobAd[count];
        count = 0;
        for (int x = 0; x < listing.length; x++) {
            if (listing[x].getSalary() >= min) {
                newList[count++] = listing[x];
            }
        }
        return newList;
    }
    public static JobAd[] whichJobsRequire( String skill, JobAd[] listing ) {
        int count = 0;
        for (JobAd ad : listing) {
            for(String skills : ad.getSkills()) {
                if (skills != null && skills.equals(skill)) {
                    count++;
                    break;
                }
            }
        }
        JobAd[] newList = new JobAd[count];
        count = 0;
        for (int x = 0; x < listing.length; x++) {
            for(String skills : listing[x].getSkills()) {
                if (skills != null && skills.equals(skill)) {
                    newList[count++] = listing[x];
                    break;
                }
            }
        }
        return newList;
    }
}
