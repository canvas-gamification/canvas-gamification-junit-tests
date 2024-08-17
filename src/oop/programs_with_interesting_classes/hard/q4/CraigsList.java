package oop.programs_with_interesting_classes.hard.q4;

public class CraigsList {
    public static void main(String[] args) {
        Ad a1 = new Ad("123 Main St", 2, 900);
        Ad a2 = new Ad("234 Main St", 3, 1200);
        Ad a3 = new Ad("345 Main St", 4, 1400);
        Ad a4 = new Ad("456 Main St", 2, 980);
        Ad a5 = new Ad("567 Main St", 3, 1500);
        Ad[] availableHousing = {a1, a2, a3, a4, a5};

        Ad[] twoRooms = filteredByRooms(2, availableHousing);
        System.out.println("Searching for two rooms... ");
        printAdList(twoRooms);

        Ad[] affordableRooms = filteredByMaxRent(1300, availableHousing);
        System.out.println("Searching for 1300 and under rooms... ");
        printAdList(affordableRooms);
    }

    public static void printAdList(Ad[] list) {
        for (int x = 0; x < list.length; x++) {
            System.out.println("Ad " + (x + 1) + ":");
            System.out.println(list[x]);
        }
    }

    public static Ad[] filteredByRooms(int target, Ad[] fullList) {
        int count = 0;
        for (Ad ad : fullList) {
            if (ad.getNumberOfRooms() == target) {
                count++;
            }
        }
        Ad[] newList = new Ad[count];
        count = 0;
        for (int x = 0; x < fullList.length; x++) {
            if (fullList[x].getNumberOfRooms() == target) {
                newList[count++] = fullList[x];
            }
        }
        return newList;
    }

    public static Ad[] filteredByMaxRent(double threshold, Ad[] fullList) {
        int count = 0;
        for (Ad ad : fullList) {
            if (ad.getMonthlyRent() <= threshold) {
                count++;
            }
        }
        Ad[] newList = new Ad[count];
        count = 0;
        for (int x = 0; x < fullList.length; x++) {
            if (fullList[x].getMonthlyRent() <= threshold) {
                newList[count++] = fullList[x];
            }
        }
        return newList;
    }
}
