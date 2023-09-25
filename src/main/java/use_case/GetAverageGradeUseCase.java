package use_case;
import api.GradeDB;
import api.MongoGradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.

        String[] myTeam = gradeDB.getMyTeam().getMembers();
        int sum = 0;

        for (int i = 0; i < myTeam.length; i ++ ) {
            sum += gradeDB.getGrade(myTeam[i], course).getGrade();
        }

        return (float) sum / myTeam.length;
    }
}
