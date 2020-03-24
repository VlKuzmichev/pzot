package rzd.oao.zrw.pzot.model;

public enum Status {
    INACTIVE, // Not allowed (Users don't see test)
    ACTIVE, // Allowed (Test appearing for users)
    COMPLETED; // Selected by Examiner for complete testing
               // (Users see the testing is accomplished)
}
