public class BirdWatcher {
    private int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public static int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay) {
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int days) {
        if (days > birdsPerDay.length) {
            days = birdsPerDay.length;
        }
        int total = 0;
        for (int i = 0; i < days; i++) {
            total += birdsPerDay[i];
        }
        return total;
    }
    public int getBusyDays() {
        int busyDays = 0;
        for (int count : birdsPerDay) {
            if (count >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }

    public static void main(String[] args) {
        int[] birdCounts = {2, 5, 0, 7, 4, 1};
        BirdWatcher birdWatcher = new BirdWatcher(birdCounts);
        int[] lastWeek = BirdWatcher.getLastWeek();
        System.out.println("Last week's bird counts: ");
        for (int count : lastWeek) {
            System.out.print(count + " ");
        }
        System.out.println();
        System.out.println("Today's bird count: " + birdWatcher.getToday());
        birdWatcher.incrementTodaysCount();
        System.out.println("After increment, today's bird count: " + birdWatcher.getToday());
        System.out.println("Has day without birds: " + birdWatcher.hasDayWithoutBirds());
        int days = 4;
        System.out.println("Total bird count for the first " + days + " days: " + birdWatcher.getCountForFirstDays(days));
        System.out.println("Number of busy days: " + birdWatcher.getBusyDays());
    }
}
