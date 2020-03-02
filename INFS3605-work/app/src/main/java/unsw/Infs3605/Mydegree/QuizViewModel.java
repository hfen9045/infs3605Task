package unsw.Infs3605.Mydegree;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {

    private QuizRepository mRepository;
    private LiveData<List<Quiz>> mTopic1Quiz;
    private LiveData<List<Quiz>> mTopic2Quiz;
    private LiveData<List<Quiz>> mTopic3Quiz;


    public QuizViewModel(Application application) {
        super(application);
        mRepository = new QuizRepository(application);
        mTopic1Quiz = mRepository.getTopic1Quiz();
        mTopic2Quiz = mRepository.getTopic2Quiz();
        mTopic3Quiz = mRepository.getTopic3Quiz();

    }

    LiveData<List<Quiz>> getAllQuiz(int topic) {
        Log.d("Number", "topic is " + topic);
        switch (topic) {
            case 1:
                return mTopic1Quiz;
            case 2:
                return mTopic2Quiz;
            case 3:
                return mTopic3Quiz;
            default:
                return mTopic1Quiz;
        }
    }

    void insert(Quiz quiz) {
        mRepository.insert(quiz);
    }
}
