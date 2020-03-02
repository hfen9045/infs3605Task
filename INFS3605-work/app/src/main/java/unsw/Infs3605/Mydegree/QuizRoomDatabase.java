package unsw.Infs3605.Mydegree;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Quiz.class}, version = 4)
public abstract class QuizRoomDatabase extends RoomDatabase {

    public abstract QuizDao quizDao();

    private static volatile QuizRoomDatabase INSTANCE;

    static QuizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizRoomDatabase.class, "quiz_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final QuizDao mDao;

        PopulateDbAsync(QuizRoomDatabase db) {
            mDao = db.quizDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mDao.deleteAll();

            Quiz quiz = new Quiz(1, 1, true, false,
                    3,
                    "What is the limit of year 1 courses you can take?",
                    "8",
                    "9",
                    "10",
                    "11",
                    "The Information Systems Degree limits students to only completing 10 level 1 courses(60UOC).There are 7 compulsory level 1 courses in the Information Systems degree so a maximum of 3 extra level 1 courses can be completed"
            );
            mDao.insert(quiz);

            quiz = new Quiz(2, 1, false, false,
                    1,
                    "INFS1603 is a core course",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS1603 is one of the core courses for the INFS degree"
            );
            mDao.insert(quiz);

            quiz = new Quiz(3, 1, false, false,
                    2,
                    "INFS1603 has prerequisite courses than need to be completed",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS1603 is a level 1 course that does not require any prerequisite knowledge"
            );
            mDao.insert(quiz);

            quiz = new Quiz(4, 1, true, false,
                    2,
                    "Which of these is not a compulsory level 1 course?",
                    "INFS1602",
                    "FINS1613",
                    "INFS1609 ",
                    "MGMT1001",
                    "INFS1602, INFS1609 and MGMT1001 are all compulsory courses that students must complete. FINS1613 however, is not mandatory but can be completed as a free elective."
            );
            mDao.insert(quiz);

            quiz = new Quiz(5, 2, false, false,
                    2,
                    "I have to complete all my level 1 courses before I can start my level 2 courses.",
                    "True",
                    "False",
                    "",
                    "",
                    "While level 2 courses will have prerequisite courses, students are able to complete some courses without having completed all of their level 1 courses. For example, INFS2603 only INFS1602 and INFS1603 as prerequisites but not INFS1609."
            );
            mDao.insert(quiz);




            quiz = new Quiz(6, 2, true, false,
                    4,
                    "How many compulsory courses are there in the INFS degree?",
                    "13",
                    "14",
                    "15",
                    "16",
                    "There are 16 courses (96 UOC) which are considered compulsory for the Information Systems Degree. If you do not complete any of the courses, you will not be elligible to graduate."
            );
            mDao.insert(quiz);

            quiz = new Quiz(7, 2, true, false,
                    1,
                    "Which of the following is not a compulsory level 2 course?",
                    "INFS2631",
                    "INFS2621",
                    "INFS2628",
                    "INFS2605",
                    "INFS2621, INFS2628, and INFS2605 are all level core courses along with INFS2603. INFS2631 is an Information Systems elective."
            );
            mDao.insert(quiz);

            quiz = new Quiz(8, 2, true, false,
                    2,
                    "How many General Education Courses can you take?",
                    "1",
                    "2",
                    "3",
                    "4",
                    "You are required to complete 2 general education courses (12UOC), which are courses taken outside of the Business School."
            );
            mDao.insert(quiz);

            quiz = new Quiz(9, 3, false, false,
                    2,
                    "I have to complete all my level 1 and level 2 courses before I can start my level 3 courses.",
                    "True",
                    "False",
                    "",
                    "",
                    "While level 3 courses will have prerequisite courses, students are able to complete some courses without having completed all of their level 1 and level 2 courses."
            );
            mDao.insert(quiz);

            quiz = new Quiz(10, 3, true, false,
                    3,
                    "What is the minimum number of Stage 2/3 Information Systems Electives that I must complete?",
                    "0",
                    "1",
                    "2",
                    "3",
                    "2 electives must be chosen out of the following five courses: INFS2631, INFS3020, INFS3632, INFS3830, and INFS3873"
            );
            mDao.insert(quiz);



            quiz = new Quiz(11, 3, true, false,
                    4,
                    "Which of the following is a compulsory level 3 course?",
                    "INFS3830",
                    "INFS3632",
                    "INFS3020",
                    "INFS3634",
                    "INFS3634 is a compulsory level 3 course while the other 3 INFS3830, INFS3632, and INFS3020 are all considered electives"
            );
            mDao.insert(quiz);

            quiz = new Quiz(12, 3, false, false,
                    1,
                    "INFS3873 is a Information Systems Elective",
                    "True",
                    "False",
                    "",
                    "",
                    "INFS3873 is an elective that can be completed by an INFS student. 2 electives must be chosen out of the following five: INFS2631, INFS3020, INFS3632, INFS3830, and INFS3873"
            );


            mDao.insert(quiz);



            return null;
        }
    }

}
