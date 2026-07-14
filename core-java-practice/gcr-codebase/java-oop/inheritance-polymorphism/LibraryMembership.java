public class LibraryMembership {
    static class LibraryMember {
        String memberName;
        String memberId;

        public LibraryMember(String memberName, String memberId) {
            this.memberName = memberName;
            this.memberId = memberId;
        }

        public double calculateFine(int overdueDays) {
            return 0.0;
        }

        public void printDetails() {
            System.out.println("Member ID: " + memberId + " | Name: " + memberName);
        }
    }

    static class StudentMember extends LibraryMember {
        public StudentMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        public double calculateFine(int overdueDays) {
            return overdueDays * 0.50;
        }
    }

    static class FacultyMember extends LibraryMember {
        public FacultyMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        public double calculateFine(int overdueDays) {
            return overdueDays * 0.20;
        }
    }

    static class GuestMember extends LibraryMember {
        public GuestMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        @Override
        public double calculateFine(int overdueDays) {
            return overdueDays * 1.50;
        }
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Alice", "S101"),
            new FacultyMember("Dr. Bob", "F201"),
            new GuestMember("Charlie", "G301")
        };

        String searchId = "F201";
        int overdue = 5;

        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                m.printDetails();
                System.out.println("Calculated Fine for " + overdue + " days: $" + m.calculateFine(overdue));
            }
        }
    }
}
