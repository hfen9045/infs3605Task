package unsw.Infs3605.Mydegree;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;



class QuizRepository {

    private QuizDao mQuizDao;


    private LiveData<List<Quiz>> mQuizTopic1;
    private LiveData<List<Quiz>> mQuizTopic2;
    private LiveData<List<Quiz>> mQuizTopic3;




    QuizRepository(Application application) {
        QuizRoomDatabase db = QuizRoomDatabase.getDatabase(application);
        mQuizDao = db.quizDao();
        mQuizTopic1 = mQuizDao.getTopic1();
        mQuizTopic2 = mQuizDao.getTopic2();
        mQuizTopic3 = mQuizDao.getTopic3();

    }






    LiveData<List<Quiz>> getTopic1Quiz() {
        return mQuizTopic1;
    }
    LiveData<List<Quiz>> getTopic2Quiz() {
        return mQuizTopic2;
    }
    LiveData<List<Quiz>> getTopic3Quiz() {
        return mQuizTopic3;
    }




    void insert(Quiz quiz) {
        new insertAsyncTask(mQuizDao).execute(quiz);
    }

    private static class insertAsyncTask extends AsyncTask<Quiz, Void, Void> {

        private QuizDao mAsyncTaskDao;

        insertAsyncTask(QuizDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Quiz... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
