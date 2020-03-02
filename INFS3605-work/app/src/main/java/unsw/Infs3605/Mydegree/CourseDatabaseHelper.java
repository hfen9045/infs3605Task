package unsw.Infs3605.Mydegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CourseDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext;


    private static final int DB_VERSION = 7;
    private static final String DB_NAME = "Courses.db";
    private static final String DB_TABLE = "Courses";

    private static final String CourseTitle = "title";
    private static final String CourseFaculty = "faculty";
    private static final String CourseDescription = "description";
    private static final String AssessmentStructure = "assessment";
    private static final String CourseType = "type";
    private static final String IsEnabled = "enabled";
    private static final String IsCompleted = "completed";
    private static final String courseError = "error";
    private static final String term = "term";
    private static final String t1 = "term1";
    private static final String t2 = "term2";
    private static final String t3 = "term3";
    private static final String prereq = "prereq";


    private SQLiteDatabase dbase;
    private int rowCount = 0;


    public CourseDatabaseHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INT, %s INT, %s TEXT, %s TEXT, %s INT, %s INT, %s INT, %s INT )", DB_TABLE, CourseTitle, CourseFaculty, CourseDescription, AssessmentStructure, CourseType, IsEnabled, IsCompleted, courseError, term, t1, t2, t3, prereq);
        db.execSQL(sqlQuery);

        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);

        addCourses();
    }

    private void addCourses() {
        Course c1 = new Course("INFS1602", "Information Systems", "Digital Transformation in Business \n\nStudents will learn to appreciate existing and emerging technologies affecting businesses, business relationships and their products and services. ", "Assessment Structure: \n- Final Exam: 100%", "Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c1);
        Course c2 = new Course("INFS1603", "Information Systems", "Introduction to Business Databases \n\nStudents will be introduced to the concepts, techniques, and technologies relevant for creating and managing business databases. ", "Assessment Structure: \n- Midsession Quiz: 50% \n- Final Exam: 50%", "Core", 1, 0, "This course is only offered in T1 & T2", "", 1, 1, 0, 1);
        this.addCourseToDB(c2);
        Course c3 = new Course("INFS1609", "Information Systems", "Fundamentals of Business Programming \n\nINFS1609 introduces students to application programming. The course provides a first step towards learning the principles of object-oriented programming through the Java programming language. ", "Assessment Structure: \n- Midsession Quiz: 50% \n- Final Exam: 50%", "Core", 1, 0, "This course is only offered in T1 & T3", "", 1, 0, 1, 1);
        this.addCourseToDB(c3);
        Course c4 = new Course("INFS2603", "Information Systems", "Business Analysis \n\nINFS2603 furthers student's knowledge and skills in relation to business systems analysis through different methodologies and approaches. ", "Assessment Structure: \n- Tutorial Participation: 20% \n- Group Assignment: 30% \n- Final Exam: 50%  ", "Core", 0, 0, "This course is only offered in T3 \n\n Prerequisites: INFS1602 and INFS1603", "", 0, 0, 1, 0);
        this.addCourseToDB(c4);
        Course c5 = new Course("INFS2605", "Information Systems", "Intermediate Business Programming \n\nStudents will then expand their application development skills and knowledge through the study of Model View Controller (MVC) architecture, event-driven programming, Graphical User Interfaces (GUI) and User Experience (UX) design. ", "Assessment Structure: \n-T utorial Participation: 10% \n- Midsession Quiz: 20% \n- Group Assignment: 30% \n- Final Exam: 40%  ", "Core", 0, 0, "This course is only offered in T1 & T3 \n\nPrerequisites: INFS1603 and INFS1609", "", 1, 0, 1, 0);
        this.addCourseToDB(c5);
        Course c6 = new Course("INFS2608", "Information Systems", "Database Management & Big Data Infrastructures \n\nStudents will learn to evaluate issues associated with big data management and business data analytics such as data quality and security. ", "Assessment Structure: \n- Tutorial Participation: 10% \n- Midsession Quiz: 10% \n- Group Assignment: 30% \n- Final Exam: 50%  ", "Core", 0, 0, "This course is only offered in T1 \n\nPrerequisites: INFS1603", "", 1, 0, 0, 0);
        this.addCourseToDB(c6);
        Course c7 = new Course("INFS2621", "Information Systems", "Enterprise Systems \n\nStudents will learn to develop models for selected business process including procurement, fulfilment and logistics. Students will learn to communicate the challenges in the selection, acquisition and implementation of Enterprise Systems. ", "Assessment Structure: \n- SAP Labs and Participation: 25% \n- Midsession Quiz: 15% \n- Group Assignment: 20% \n- Final Exam: 40%  ", "Core", 0, 0, "This course is only offered in T2 \n\nPlease ensure you have completed the following prerequisites: INFS1602", "", 0, 1, 0, 0);
        this.addCourseToDB(c7);
        Course c8 = new Course("INFS3603", "Information Systems", "Introduction to Business Analytics \n\nStudents will develop skills in SAS Visual Analytics, critical thinking, problem-solving, research, communication and team-working skills through group assignments. ", "Assessment Structure: \n- Tutorial Participation: 20% \n- Group Assignment: 30% \n- Final Exam: 50%  ", "Core", 0, 0, "This course is only offered in T1 & T2 \n\nPrerequisites: INFS1602", "", 1, 1, 0, 0);
        this.addCourseToDB(c8);
        Course c9 = new Course("INFS3604", "Information Systems", "Business Process Management \n\nStudents will learn about Business Process Management (BPM), such as the concepts, methods, and techniques that support the design, improvement, management, configuration, enactment, and analysis of business processes that deliver lean and customer focused business processes. ", "Assessment Structure: \n- Workshop: 10% \n- Midsession Quiz: 10% \n- Group Assignment: 30% \n- Final Exam: 50%  ", "Core", 0, 0, "This course is only offered in T3 \n\nPrerequisites: INFS2603", "", 0, 0, 1, 0);
        this.addCourseToDB(c9);
        Course c10 = new Course("INFS3605", "Information Systems", "Information Systems Innovation & Transformation \n\nThis is the capstone IS course that is centrally organised around practical, experiential, group software projects. Students will apply programming knowledge and teamwork learnt in previous courses in an applied and integrated fashion.", "Assessment Structure: \n- Workshop Participation: 15% \n- Individual Assignment 1: 25% \n- Group Assignment: 30% \n- Individual Assignment 2: 30%", "Core", 0, 0, "This course is only offered in T1 & T2 \n\nPrerequisites: INFS3634", "", 1, 1, 0, 0);
        this.addCourseToDB(c10);
        Course c11 = new Course("INFS3617", "Information Systems", "Networking & Cyber Security \n\nStudents will be developing their knowledge and understanding in information technology infrastructure and security in a business environment. ", "Assessment Structure: \n- Tutorial Participation: 20% \n- Midsession Quiz: 15% \n- Group Assignment: 15% \n- Final Exam: 50%  ", "Core", 0, 0, "This course is only offered in T1 \n\nPrerequisites: INFS1602", "", 1, 0, 0, 0);
        this.addCourseToDB(c11);
        Course c12 = new Course("INFS3634", "Information Systems", "Mobile Applications Development \n\nStudents will be able to learn various concepts and skills that are essential in careers such as project designers and software developers. ", "Assessment Structure: \n- Tutorial Participation: 10% \n- Homework: 20% \n- Group Assignment: 30% \n- Final Exam: 40%  ", "Core", 0, 0, "This course is only offered in T1 & T3 \n\nPrerequisites: INFS2605", "", 1, 0, 1, 0);
        this.addCourseToDB(c12);
        Course c13 = new Course("ACCT1501", "Accounting", "Accounting & Financial Management 1A \n\nThis will provide an introduction to basic concepts in accounting and their application for decision making by a wide range of potential users.", "Assessment Structure: \n- Tutorial Participation: 10% \n- Midsession Quiz: 25% \n- Online Quiz: 15% \n- Final Exam: 50%  ", "Business Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c13);
        Course c14 = new Course("MGMT1001", "Management", "Managing Organisations & People \n\nThis course introduces students to the knowledge and skills required for the development of future organisational leaders and managers who will be able to successfully respond to complex and turbulent environments.", "Assessment Structure: \n- Tutorial Participation: 15% \n- Liberty Air Gamulation: 10% \n- Professional Development Portfolio: 35% \n- Final Exam: 40%  ", "Business Core", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c14);
        Course c15 = new Course("ECON1203", "Economics", "Business & Economic Statistics \n\nCourse topics include: descriptive statistics, probably distributions, point and interval estimation of parameters, hypothesis testing and regression models.", "Assessment Structure: \n- Case Study Assessment: 25% \n- Midsession Quiz: 20% \n- Reflection: 5% \n- Final Exam: 50%  ", "Business Core", 1, 0, "Sorry, you can only choose either MATH1041 or ECON1203 for Business Core Course structure.", "", 1, 1, 1, 1);
        this.addCourseToDB(c15);
        Course c16 = new Course("MATH1041", "Mathematics & Statistics", "Statistics for Life & Social Sciences \n\nStudents learn robability, random variables, independence, discrete distributions, poisson and binomial distributions, data analysis, descriptive statistics, sampling, continuous distributions, the normal distribution, estimation of mean and variance, tests of hypotheses, linear regression and correlation. ", "Assessment Structure: \n- Online Tutorials: 10% \n- Midsession Online Quiz: 15% \n- Assignment: 15% \n- Final Exam: 60%  ", "Business Core", 1, 0, "Sorry, you can only choose either MATH1041 or ECON1203 for Business Core Course structure.", "", 1, 1, 1, 1);
        this.addCourseToDB(c16);
        Course c17 = new Course("ACCT1511", "Accounting", "Accounting & Financial Management 1B \n\nStudents develop technical competence in recording economic events in the accounting system; a critical understanding of key technical terms and concepts so as to interpret accounting information and reports in the financial press; an ability to argue a reasoned position on key questions of accounting theory and practice; and familiarity with institutional structures that affect the practice of accounting. \n", "Assessment Structure: \n- Assignment 1: 20% \n- Assignment 2: 20% \n- Online Bonus Participation: 5% \n- Final Exam: 60%  ", "Business Core", 1, 0, "This course is only offered in T1 & T2,\n\nPlease ensure you can only choose either ACCT 1511 or ECON1101 for Business Core Course structure.", "", 1, 1, 0, 1);
        this.addCourseToDB(c17);
        Course c18 = new Course("ECON1101", "Economics", "Microeconomics 1 \n\nStudents learn topics such as how individuals or firms make decisions about the demand or supply of a product, how we can determine the efficiency of a market, and how we evaluate the costs and benefits of government intervention in a market.\n", "Assessment Structure: \n- Playconomics: 20% \n- Midsession Quiz: 25% \n- Final Exam: 55%  ", "Business Core", 1, 0, "Sorry, you can only choose either ACCT 1511 or ECON1101 for Business Core Course structure.", "", 1, 1, 1, 1);
        this.addCourseToDB(c18);
        Course c19 = new Course("INFS2631", "Information Systems", "Innovation and Technology Management \n\nThis course will analyse how small and large firms innovate, commercial and compete in competitive markets through the development and management of technology.\n\n", "Assessment Structure: \n- Tutorial Participation: 10% \n- Pre-Class Activities: 15% \n- Group Assignment: 25% \n- Final Exam: 50%", "Prescribed Elective", 0, 0, "This course is only offered in T1 \n\nPrerequisites: INFS1602", "", 1, 0, 0, 0);
        this.addCourseToDB(c19);
        Course c20 = new Course("INFS3020", "Information Systems", "International Information Systems and Technology Practicum \n\nThis course affords students the opportunity to develop knowledge and understanding of international aspect of information systems/technology (IS/IT) business operations (e.g. global IS/IT teams, distributed systems development, eBusiness, and localisation management) through the firsthand observation of businesses in Asian countries such as China, India, Hong Kong, and South Korea. \n", "Assessment Structure: \n- Workshop and Field Trip Participation: 30% \n- Team Project: 30% \n- Individual Practicum Report: 20% \n- Individual Reflection Essay: 15%", "Prescribed Elective", 0, 0, "This course is only offered in T2", "", 0, 1, 0, 1);
        this.addCourseToDB(c20);
        Course c21 = new Course("INFS3632", "Information Systems", "Service and Quality Management \n\nThis course will teach skills and tools such as Statistical Quality Control, Six-Sigma, and Lean Operations, which are valuable for service process quality control. I", "Assessment Structure: \n- Tutorial Participation: 5% \n- Homework: 40% \n- Group Assignment: 15% \n- Final Exam: 40%  ", "Prescribed Elective", 0, 0, "This course is only offered in T2 \n\nPrerequisites: INFS1602", "", 0, 1, 0, 0);
        this.addCourseToDB(c21);
        Course c22 = new Course("INFS3830", "Information Systems", "Social Media Analytics \n\nThe topics covered in this course include The Rise of Social Media, Enterprise 2.0 and Social Software, Social Media Strategy and Engagement, Applied Analytics using SAS, Social Media Analytics Tools, Social Media Network: Structure and Content, Translating Social Media Data into Business Insights, Social Commerce and Risk Management, Ethical Issues in Social Media Application and Analytics.", "Assessment Structure: \n- Individual Assignment: 15% \n- SAS Hands-On Exercise: 15% \n- Group Assignment: 25% \n- Final Exam: 45%  ", "Prescribed Elective", 0, 0, "This course is only offered in T1 \n\nPrerequisites: INFS3603", "", 1, 0, 0, 0);
        this.addCourseToDB(c22);
        Course c23 = new Course("INFS3873", "Information Systems", "Business Analytics Method \n\nThe topics covered in this course include Introduction to Data Science, Analytics in Spreadsheets, Descriptive Statistical Measures, Probability Distributions, Sampling and Estimation, Statistical Inference, Visual Analytics, Linear Regression, Logistic Regression, Classification Trees, Clustering and Segmentation, Dashboards and Communication, Presentations. ", "Assessment Structure: \n- Online Quiz: 20% \n- Individual Assignment: 20% \n- Group Assignment: 20% \n- Final Exam: 40%  ", "Prescribed Elective", 0, 0, "This course is only offered in T3 \n\nPrerequisites: INFS3603", "", 0, 0, 1, 0);
        this.addCourseToDB(c23);
        Course c24 = new Course("GE#1", "GE", "any General Education course", "", "General Education", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c24);
        Course c25 = new Course("GE#2", "GE", "any General Education course", "", "General Education", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c25);
        Course c26 = new Course("FE#1", "FE", "any course", "", "Free Elective", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c26);
        Course c27 = new Course("FE#2", "FE", "any course", "", "Free Elective", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c27);
        Course c28 = new Course("FE#3", "FE", "any course", "", "Free Elective", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c28);
        Course c29 = new Course("FE#4", "FE", "any course", "", "Free Elective", 1, 0, "", "", 1, 1, 1, 1);
        this.addCourseToDB(c29);
    }


    public void addCourseToDB(Course c) {
        ContentValues values = new ContentValues();
        values.put(CourseTitle, c.getCourseTitle());
        values.put(CourseFaculty, c.getCourseFaculty());
        values.put(CourseDescription, c.getCourseDescription());
        values.put(AssessmentStructure, c.getAssessmentStructure());
        values.put(CourseType, c.getCourseType());
        values.put(IsEnabled, c.getIsEnabled());
        values.put(IsCompleted, c.getIsCompleted());
        values.put(courseError, c.getCourseError());
        values.put(term, c.getTerm());
        values.put(t1, c.getT1());
        values.put(t2, c.getT2());
        values.put(t3, c.getT3());
        values.put(prereq, c.getPrereq());

        dbase.insert(DB_TABLE, null, values);

    }

    public List<Course> getAllCoreCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Core' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);

            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllBusCoreCourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Business Core' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);

            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllPECourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Prescribed Elective' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllFECourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Free Elective' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getGECourses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type ='General Education' AND completed = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }





    public void updateIsCompleted(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsCompleted +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void updateIsNotCompleted(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsCompleted +
                " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void updatePrereq(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + prereq +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void eitherPrereq(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + prereq +
                " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void eitherdisable(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void eitherenable(String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }

    public void updateEnable(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);
        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 1 + "' WHERE " + CourseTitle + " = '" + title + "'";
            db.execSQL(query);
        }

    }

    public void updateEnable2(List<Course> course) {

        SQLiteDatabase db = this.getWritableDatabase();
        //db.rawQuery("SELECT enabled FROM courses WHERE title = ?", course);
        for (int i = 0; i < course.size(); i++) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 1 + "' WHERE " + CourseTitle + " = '" + course + "'";
            //String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
            //" = '" + 1 + "' WHERE " + CourseTitle + " IN (" + course+ ")";
            db.execSQL(query);
        }

    }

    public int getIsCompleted(String course) {
        dbase = this.getReadableDatabase();
        int isComplete;
        String selectQuery = "SELECT completed FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        } else {
            isComplete = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return isComplete;
    }

    public int getPrereq(String course) {
        dbase = this.getReadableDatabase();
        int prereq;
        String selectQuery = "SELECT prereq FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            prereq = cursor.getInt(cursor.getColumnIndex("prereq"));
        } else {
            prereq = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return prereq;
    }

    public int getIsEnabled(String course) {
        dbase = this.getReadableDatabase();
        int isComplete;
        String selectQuery = "SELECT enabled FROM " + DB_TABLE + " WHERE " + CourseTitle + "='" + course + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            isComplete = cursor.getInt(cursor.getColumnIndex("enabled"));
        } else {
            isComplete = 2;
        }
        //int isComplete = cursor.getInt(cursor.getColumnIndex("completed"));
        return isComplete;
    }


    public void updateDisable(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);

        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 0 + "' WHERE " + CourseTitle + " = '" + title + "'";
            db.execSQL(query);
        }

    }

    public void updatepq(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);

        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            String query = "UPDATE " + DB_TABLE + " SET " + prereq +
                    " = '" + 0 + "' WHERE " + CourseTitle + " = '" + title + "'";
            db.execSQL(query);
        }

    }

    //wip

    public void updateDisable3(List<String> course) {

        String[] courseStrings = new String[course.size()];
        courseStrings = course.toArray(courseStrings);

        SQLiteDatabase db = this.getWritableDatabase();
        for (String title : courseStrings) {
            db.execSQL(String.format("UPDATE courses SET enabled = 0 WHERE title = ?", title));
        }

        //db.rawQuery("UPDATE courses SET enabled = 0 WHERE title =?", courseStrings);
        /*SQLiteDatabase db = this.getWritableDatabase();
            String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                    " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
            db.execSQL(query);*/

    }

    public List<String> getDisable() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE enabled = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }


    public void updateDisable2(List<Course> course) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + IsEnabled +
                " = '" + 0 + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);
    }


    public void updateTerm(String course, String termSelected) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + DB_TABLE + " SET " + term +
                " = '" + termSelected + "' WHERE " + CourseTitle + " = '" + course + "'";
        db.execSQL(query);

    }

    public List<Course> getAllT1Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T1' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllT2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT3Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT1Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T1Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllT2Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T2Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT3Y2Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T3Y2' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT1Y3Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T1Y3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }

    public List<Course> getAllT2Y3Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T2Y3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getAllT3Y3Courses() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE term = 'T3Y3' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public int getRemainingCoreCourses() {
        int coreRequirement = 12;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Core' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedCore = courseList.size();
        int remainingCore = coreRequirement - completedCore;

        return remainingCore;

    }

    public int getRemainingBusCoreCourses() {
        int coreRequirement = 4;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Business Core' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedBusCore = courseList.size();
        int remainingBusCore = coreRequirement - completedBusCore;

        return remainingBusCore;

    }


    public int getRemainingPECourses() {
        int coreRequirement = 2;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Prescribed Elective' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedPE = courseList.size();
        int remainingPE = coreRequirement - completedPE;

        return remainingPE;

    }


    public int getRemainingFECourses() {
        int electiveRequirement = 4;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Free Elective' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedFE = courseList.size();
        int remainingFE = electiveRequirement - completedFE;

        return remainingFE;
    }

    public int getRemainingGECourses() {
        int generalRequirement = 2;
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'General Education' AND completed = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        int completedGE = courseList.size();
        int remainingGE = generalRequirement - completedGE;

        return remainingGE;
    }

    public List<String> getT1RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term1 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT1PERemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term1 = 1 AND prereq = 1 AND type = 'Prescribed Elective'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT2PERemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 1 AND prereq = 1 AND type = 'Prescribed Elective'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT3PERemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term3 = 1 AND prereq = 1 AND type = 'Prescribed Elective'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT1RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term1 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT2RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getPE() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE type = 'Prescribed Elective'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }


        return array;
    }

    public List<String> getT2RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }

    public List<String> getT3RemAvail() {
        List<String> array = new ArrayList<String>();
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term3 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }

    public List<String> getT3RemUnavail() {
        List<String> array = new ArrayList<String>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term3 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        while (cursor.moveToNext()) {
            String uname = cursor.getString(cursor.getColumnIndex("title"));
            array.add(uname);
        }

        return array;
    }


    //Original Code (did not work). Here as reference.

    public List<Course> getT2RemAvail2() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 1 AND prereq = 1";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }

        return courseList;
    }

    public List<Course> getT2RemUnavail2() {
        List<Course> courseList = new ArrayList<Course>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DB_TABLE + " WHERE completed = 0 AND term2 = 0";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        rowCount = cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                Course c = new Course();
                c.setCourseTitle(cursor.getString(0));
                c.setCourseFaculty(cursor.getString(1));
                c.setCourseDescription(cursor.getString(2));
                c.setAssessmentStructure(cursor.getString(3));
                c.setCourseType(cursor.getString(4));
                c.setIsEnabled(cursor.getInt(5));
                c.setIsCompleted(cursor.getInt(6));
                c.setCourseError(cursor.getString(7));
                c.setTerm(cursor.getString(8));
                c.setT1(cursor.getInt(9));
                c.setT2(cursor.getInt(10));
                c.setT3(cursor.getInt(11));
                c.setPrereq(cursor.getInt(12));
                courseList.add(c);


            } while (cursor.moveToNext());
        }
        return courseList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }

    public int getRowCount() {
        return rowCount;
    }

}
