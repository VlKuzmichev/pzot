package rzd.oao.zrw.pzot.model;

public enum Status {
    INACTIVE, // Not allowed (Users don't see test)
    ACTIVE, // Allowed (Test appearing for users)
    STARTED, // Already started by any user(using for ban to delete test by Examiner)
    COMPLETED; // Selected by Examiner for complete testing
               // (Users see the testing is accomplished)
}
