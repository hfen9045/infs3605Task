package unsw.Infs3605.Mydegree;

import java.util.ArrayList;

public class CourseArrayList {

    private String courseid;
    private String coursefaculty;
    private String coursename;
    private String coursedescription;
    private String assessment;
    private String termavavailability;
    private String prereq;


    public CourseArrayList() {
    }


    public CourseArrayList(String courseid, String coursefaculty, String coursename, String coursedescription, String assessment, String termavavailability, String prereq) {
        this.courseid = courseid;
        this.coursefaculty = coursefaculty;
        this.coursename = coursename;
        this.coursedescription = coursedescription;
        this.assessment = assessment;
        this.termavavailability = termavavailability;
        this.prereq = prereq;
    }


    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursefaculty() {
        return coursefaculty;
    }

    public void setCoursefaculty(String coursefaculty) {
        this.coursefaculty = coursefaculty;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getTermavavailability() {
        return termavavailability;
    }

    public void setTermavavailability(String termavavailability) {
        this.termavavailability = termavavailability;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }



    public static ArrayList<CourseArrayList> getDummyCourses() {

        ArrayList<CourseArrayList> course1 = new ArrayList<>();

        course1.add(new CourseArrayList("INFS1602", "School of Information Systems and Technology Management", "Digital Transformation in Business", "As an overarching theme, INFS1602 examines the issues and management of IS in relation to human behaviour and its consequences. \n" +
                "\n" +
                "The topics that are covered in INFS1602 include understanding the role of Information Systems and IS Professionals in Global Business, the relationship between Information Systems, Organisations, and Strategy, the dominant Business Models enabled by the Internet and Web 2.0 technology. The course also touches on popular enterprise-level information systems such as Enterprise Systems, Supply Chain and Customer Relationship Management Systems and the emergence of business intelligence in supporting organisation decision making. The course also involves discussion of the considerations behind the acquisition and building of IS and the issues common to the management of IS projects. Lastly, the course addresses the need to secure the IS and the potential ethical and social issues faced by businesses in relation to their use of IS.\n" +
                "\n" +
                "Students will learn the foundations necessaary for future IS courses.", "- Worshop Participation and MyLab MIS: 20%\n" +
                "- Midsession Quiz: 15%\n" +
                "- Team Project 15%\n" +
                "- Final Exam 50% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("INFS1603", "School of Information Systems and Technology Management", "Introduction to Business Databases", "INFS1603 introduces students to the concepts, techniques, and technologies relevant for creating and managing business databases. \n" +
                "\n" +
                "It will explain the major components of IS, which are critical to capturing, transmitting, storing, retrieving, manipulating and displaying information used in business processes. Students will be given tasks and assignments to help them acquire the ability to create and manage business databases.\n" +
                "\n" +
                "Through this course, students will be exposed to the fundamental knowledge of business databases, which are foundational for many advanced courses. ", "- Lab Exercises: 10%\n" +
                "- Assignment (Group Project: Written Report and Oral Presentation): 30%\n" +
                "- Week 5 Quiz: 10%\n" +
                "- Final Exam 50% \n", "This course is only offered in T1 & T2", "Not Applicable"));
        course1.add(new CourseArrayList("INFS1609", "School of Information Systems and Technology Management","Fundamentals of Business Programming", "INFS1609 introduces students to application programming. The course provides a first step towards learning the principles of object-oriented programming through the Java programming language.\n" +
                "\n" +
                "The topics include an overview of data types and methods, introducing students to small problem-solving exercises that require the use of conditional statements, loops and arrays (including multi-dimensional arrays and array lists). Students are then introduced to the topics of modular programming, testing and debugging (using JUNIT). Finally, having gained a general understanding of these concepts, students further explore the principles of object-oriented programming, including objects, classes, abstraction, polymorphism, inheritance and encapsulation.\n" +
                "\n" +
                "The course provides a first step towards learning the principles of object-oriented programming through the Java programming language. ", "- Tutorial Preparation and Participation: 20%\n" +
                "- Individual Assignments (Week 4 and 10): 20%\n" +
                "- Mid-Term Quiz: 10%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T1 & T3", "Not Applicable"));
        course1.add(new CourseArrayList("INFS2603", "School of Information Systems and Technology Management", "Business Analysis", "INFS2603 furthers student's knowledge and skills in relation to business systems analysis through different methodologies and approaches.\n" +
                "\n" +
                "The course will teach students Agile Scrum, Design Thinking and Object-Orientation to analyse and design business information systems. Students will be also introduced to a range of methods, tools and techniques used in planning, analysing and designing information systems. ", "- Tutorial Preparation and Participation: 20%\n" +
                "- Group Assignment 30%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T3", "Please ensure you have completed the following prerequisites: INFS1602 and INFS1603"));
        course1.add(new CourseArrayList("INFS2605", "School of Information Systems and Technology Management", "Intermediate Business Programming", "INFS2605 continues the study of Java programming from INFS1609 (Fundamentals of Business Programming) and examines contemporary approaches to software development. \n" +
                "\n" +
                "The topics that are covered in INFS2605 build on the programming skills introduced in INFS1609 and the database skills in INFS1603, providing students with a thorough review of software development processes and object-oriented programming principles. Students will then expand their application development skills and knowledge through the study of Model View Controller (MVC) architecture, event-driven programming, Graphical User Interfaces (GUI) and User Experience (UX) design. ", "- Tutorial Participation: 10%\n" +
                "- Mid-Term Quiz: 20%\n" +
                "- Group Assignment: 30% \n" +
                "- Final Exam: 40% \n", "This course is only offered in T1 & T3", "Please ensure you have completed the following prerequisites: INFS1603 and INFS1609" ));
        course1.add(new CourseArrayList("INFS2608", "School of Information Systems and Technology Management", "Database Management & Big Data Infrastructures", "INFS2608 is a Level 2 Information Systems (IS) course that continues students’ study of IS by covering various advanced topics pertinent to big data management. This course will explain advanced concepts used to design and manage relational and analytical big data system infrastructure. Students will learn to evaluate issues associated with big data management and business data analytics such as data quality and security. ", "- Lab Exercises: 10%\n" +
                "- Database Project (Written Report and Oral Presentation): 30%\n" +
                "- Mid-Session Quiz: 10%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T1", "Please ensure you have completed the following prerequisites: INFS1603"));
        course1.add(new CourseArrayList("INFS2621", "School of Information Systems and Technology Management", "Enterprise Systems", "This is a Level 2 Information Systems (IS) course that continues the students’ study of IS by introducing students to Enterprise Systems used in today’s networked organisations, specifically, how they can be used by organisations to support data analytics. Students will learn to develop models for selected business process including procurement, fulfilment and logistics. Students will learn to communicate the challenges in the selection, acquisition and implementation of Enterprise Systems.", "- SAP Labs and Participation: 25%\n" +
                "- Mid-Sem Test: 15%\n" +
                "- Group Assignment Case Study: 20%\n" +
                "- Final Exam: 40% \n", "This course is only offered in T2 ", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3603", "School of Information Systems and Technology Management", "Introduction to Business Analytics", "This course provides students with an understanding of business needs and technology trends driving investment in business analytics and big data technologies. \n" +
                "\n" +
                "Topics  covered in this course include: decision-making process; business analytics concepts, methods, and frameworks; frameworks for putting analytics to work; the governance, oversight and business value gained from business analytics within organisations; ethical and social implications of business analytics; and future directions for business analytics. \n" +
                "\n" +
                "Students will develop skills in SAS Visual Analytics, critical thinking, problem-solving, research, communication and team-working skills through group assignments.", "- Preparation and Participation: 20%\n" +
                "- Team Assignment: 30%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T1 & T2", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3604", "School of Information Systems and Technology Management", "Business Process Management", "This course looks at ways in which business processes can be analysed, redesigned, and improved thus ensuring that they are meeting the needs of customers and the enterprise. \n" +
                "\n" +
                "Students will learn about Business Process Management (BPM), such as the concepts, methods, and techniques that support the design, improvement, management, configuration, enactment, and analysis of business processes that deliver lean and customer focused business processes. Students will also learn process modelling that explicitly represents processes – once they are defined, processes can be analysed, improved, and enacted.", "- Workshop Exercises: 10%\n" +
                "- Quiz: 10%\n" +
                "- Team Assignment: 30%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T3", "Please ensure you have completed the following prerequisites: INFS2603"));
        course1.add(new CourseArrayList("INFS3605", "School of Information Systems and Technology Management", "Information Systems Innovation & Transformation", "This is a Level 3 Information Systems (IS) course that concludes the students’ study of IS through the application, integration and synthesis of students’ knowledge from previous IS courses. Specifically, INFS3605 is the ‘capstone’ IS course that is centrally organised around practical, experiential, group software projects.\n" +
                "\n" +
                "The course begins with student groups brainstorming and developing their software project ideas and then gathering requirements. Following this, student groups engage in an iterative development process in designing and refining their software application using the agile scrum framework working in two-week sprints/iterations. Throughout the course, students will perform various roles (including scrum master and product owner) and ceremonies (including sprint planning, stand-up sessions, sprint reviews, sprint retrospectives and backlog refinement), as well as utilise a number of a tools (such as kanban boards, burndown charts and planning poker).\n" +
                "\n" +
                "Overall, this course requires students to perform as agile scrum teams and develop complex software applications in an iterative and incremental manner.", "- Workshop Participation: 15% \n- Individual Assignment 1: 25% \n- Group Assignment: 30% \n- Individual Assignment 2: 30% \n", "This course is only offered in T1 & T2", "Please ensure you have completed the following prerequisites: INFS3634"));
        course1.add(new CourseArrayList("INFS3617", "School of Information Systems and Technology Management", "Networking & Cyber Security", "Students will be developing their knowledge and understanding in information technology infrastructure and security in a business environment. \n" +
                "\n" +
                "Topics to be covered in this course include inter-networked data communications and distributed data processing. Topics covered include, the business imperatives for distributed systems, systems architectural design (client/server; distributed processing, etc) layered architecture models (TCP/IP, OSI, etc), key network models and technologies, security issues related to architecture, design and technology, network configuration and management techniques.", "- Tutorial Participation and Preparation: 20%\n" +
                "- Group Assignment: 15%\n" +
                "- Mid-Term Quiz: 15%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T1", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3634", "School of Information Systems and Technology Management", "Mobile Applications Development", "INFS3634 continues your study of IS by furthering your knowledge and skills in relation to mobile application development. \n" +
                "\n" +
                "Topics will include an overview of mobile programming concepts and tools, and engage in case studies with regards to mobile App development and the current mobile market. During the weekly practical tutorials, students will use the Android Studio Integrated development environment (IDE) in learning how to design and develop a range of mobile applications. \n" +
                "\n" +
                "Students will be able to learn various concepts and skills that are essential in careers such as project designers and software developers. ", "- Tutorial Participation: 10%\n" +
                "- Homework: 20%\n" +
                "- Group Assignment: 30%\n" +
                "- Final Exam: 40% \n", "This course is only offered in T1 & T3", "Please ensure you have completed the following prerequisites: INFS2605"));
        course1.add(new CourseArrayList("ACCT1501", "School of Accounting", "Accounting & Financial Management 1A", "This course provides an introduction to basic concepts in accounting and their application for decision making by a wide range of potential users (e.g., shareholders, investment analysts, lenders, managers etc). \n" +
                "\n" +
                "On completion, students should have a clear understanding of the accounting process and the language of accounting, understand the relevance of accounting information for informed decision making and have the ability to analyse and interpret accounting information. Topics covered will include the accounting equation, general purpose financial reports, cash and accrual accounting, adjustments, internal control, financial statement analysis, and interpreting and preparing information for managers to use in planning, decision making and control.\n" +
                "\n" +
                "This unit should benefit students who wish to specialise in accounting, and will also be of value to students whose primary interest lies elsewhere in the field of business.", "- Tutorial Participation: 10%\n" +
                "- Multiple Choice Online Quiz: 15%\n" +
                "- Mid - Term Quiz: 25%\n" +
                "- Final Exam: 50% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("MGMT1001", "School of Management", "Managing Organisations & People", "This course introduces students to the knowledge and skills required to successfully manage organisations and people in a global economy.\n" +
                "\n" +
                "This course covers topics that will help students to respond to complex and turbulent environments, promote and sustain strategic advantage, ensure ethical and social responsibility in business practice and decision making, and manage changing social, political and technological factors both inside and outside the organisation.", "- Participation (Lecture and Research Study): 15%\n" +
                "- Liberty Air Gamulation: 10%\n" +
                "- Professional Development Portfolio: 35%\n" +
                "- Final Exam: 40% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("ECON1203", "School of Economics", "Business & Economic Statistics", "This course introduces students to basic statistical concepts and methods that are widely used in economics, finance, accountancy, marketing and, more generally, business. \n" +
                "\n" +
                "Course topics include: descriptive statistics, probability distributions, point and interval estimation of parameters, hypothesis testing, and regression models. Students will learn to solve statistical problems in an Excel spreadsheet environment. \n" +
                "\n" +
                "This course provides the basis for further study of statistical and econometric methods.", "- Case Study Assessment: 25%\n" +
                "- Mid-Term Test: 20%\n" +
                "- Reflection: 5%\n" +
                "- Final Exam: 50% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("MATH1041", "School of Mathematics & Statistics", "Statistics for Life & Social Sciences", "This course is not intended for students who propose to study a substantial amount of Mathematics beyond first year level. \n" +
                "\n" +
                "The topics for this course include probability, random variables, independence, discrete distributions, poisson and binomial distributions, data analysis, descriptive statistics, sampling, continuous distributions, the normal distribution, estimation of mean and variance, tests of hypotheses, linear regression and correlation. Others include tests for goodness of fit and Bayesian statistics.\n" +
                "\n" +
                "As for MATH1041, please note that this course is not intended for students who propose to study a substantial amount of Mathematics beyond first year level. Many later year courses in Mathematics have completion of MATH1231, MATH1241 or MATH1251 as a prerequisite.", "- Online Tutorials: 10%\n" +
                "- Mid-Term Online Test: 15%\n" +
                "- Assignment: 15%\n" +
                "- Final Examination: 60% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("ACCT1511", "School of Accounting", "Accounting & Financial Management 1B", "This course forms an integrated study program designed to give students an understanding of the way in which financial information is generated and used, and to provide an appropriate platform for further study in accounting. \n" +
                "\n" +
                "Topics covered in this course will include accounting for non-current assets and liabilities, revenues and expenses, balance sheet and income statement preparation, cash flow statements, ratio analysis, accounting policy choice and further detail on management accounting (including costing systems and budgeting).\n" +
                "\n" +
                "On completion the first year accounting courses seek to develop students’: technical competence in recording economic events in the accounting system; a critical understanding of key technical terms and concepts so as to interpret accounting information and reports in the financial press; an ability to argue a reasoned position on key questions of accounting theory and practice; and familiarity with institutional structures that affect the practice of accounting. ", "- Assignment 1: 20%\n" +
                "- Assignment 2: 20%\n" +
                "- Final Exam: 60%\n" +
                "- Online Participation Bonus Marks: Up to 5% \n", "This course is only offered in T1 & T2", "Not Applicable"));
        course1.add(new CourseArrayList("ECON1101", "School of Economics", "Microeconomics 1", "Economics is a social science which studies the ways in which people interact with one another and make decisions in a world with limited resources. \n" +
                "\n" +
                "We will cover topics such as how individuals or firms make decisions about the demand or supply of a product, how we can determine the efficiency of a market, and how we evaluate the costs and benefits of government intervention in a market.", "- Mid-Term Test: 25%\n" +
                "- Playconomics: 20%\n" +
                "- Final Exam: 55% \n", "All terms", "Not Applicable"));
        course1.add(new CourseArrayList("INFS2631", "School of Information Systems and Technology Management", "Innovation and Technology Management", "The course aims to develop students’ conceptual knowledge and practical skills regarding managing technological innovation through various phases of the innovation process. \n" +
                "\n" +
                "This course will analyse how small and large firms innovative, commercialise and compete in competitive markets through the development and management of technology. The course emphasises the role of crowdsourcing, social media and social networks in developing, driving and managing innovations.", "- Preparation and Participation: 10%\n" +
                "- Pre-Class Activity: 15%\n" +
                "- Group Assignment: 25%\n" +
                "- Final Exam: 50% \n", "This course is only offered in T1", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3020", "School of Information Systems and Technology Management", "International Information Systems and Technology Practicium", "This course affords students the opportunity to develop knowledge and understanding of international aspect of information systems/technology (IS/IT) business operations (e.g. global IS/IT teams, distributed systems development, eBusiness, and localisation management) through the firsthand observation of businesses in Asian countries such as China, India, Hong Kong, and South Korea. \n" +
                "\n" +
                "The central components of the course include a series of seminars and a two-week study tour to one Asian country, in which a number of leading international and national companies, including companies operating in the IS/IT sector and those in other sectors with a significant IS/IT footprint, will be visited in order to enable students to develop an appreciation of the ways in which IS/IT enabled business operations and business systems differ across national boundaries.  ", "- Workshop and Field Trip Participation: 30%\n" +
                "- Team Project: 30%\n" +
                "- Individual Practicum Report: 25%\n" +
                "- Individual Reflection Essay: 15% \n", "This course is only offered in T2", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3632", "School of Information Systems and Technology Management", "Service and Quality Management", "This is a Level 3 Information Systems (IS) course that introduces students to the key concepts in managing service operations and quality management. \n" +
                "\n" +
                "This course will teach skills and tools such as Statistical Quality Control, Six-Sigma, and Lean Operations, which are valuable for service process quality control. In lectures, students will learn the 'state of the art' of process management of service firms and the opportunities provided by information technology and data analytics in enhancing their competitiveness. Students will be engaged in simulations, where they can apply the concepts learnt in the class to real-world settings and learn how to manage process variabilities and quality control. In a project which involves conducting a walk-through-audit to a real company of the students’ choice, they will learn how to implement a service business to meet customer satisfaction.", "- Homework (Individual): 40%\n" +
                "- Participation (Individual: 5%\n" +
                "- Project Report and Presentation: 15%\n" +
                "- Final Exam: 40% \n", "This course is only offered in T2", "Please ensure you have completed the following prerequisites: INFS1602"));
        course1.add(new CourseArrayList("INFS3830", "School of Information Systems and Technology Management", "Social Media Analytics", "This is a Level 3 Information Systems (IS) course that provides an introduction to the use of social media in organisation by examining the enabling effect of social media technologies for competitive advantage and the potential insights from the vast data generated on social media platforms.\n" +
                "\n" +
                "The topics covered in this course include The Rise of Social Media, Enterprise 2.0 and Social Software, Social Media Strategy and Engagement, Applied Analytics using SAS, Social Media Analytics Tools, Social Media Network: Structure and Content, Translating Social Media Data into Business Insights, Social Commerce and Risk Management, Ethical Issues in Social Media Application and Analytics.\n" +
                "\n" +
                "In addition to examining strategies to create and extract value from social media, the effect of social media on operational matters, social media metrics and strategic aspects of social media analytics, the course will incorporate a hands-on component using SAS software.", "- Individual Assignment: 15%\n" +
                "- SAS Hands-on Exercise: 15%\n" +
                "- Team Project (Written Report and Oral Presentation): 25%\n" +
                "- Final Exam: 45% \n", "This course is only offered in T1", "Please ensure you have completed the following prerequisites: INFS3603"));
        course1.add(new CourseArrayList("INFS3873", "School of Information Systems and Technology Management", "Business Analytics Method", "INFS3873 builds on key components previously covered in INFS3603 (Introduction to Business Analytics) and involves gathering and managing strategic data, transforming it into new insights, and translating those insights into effective front-line action in order to have a better understanding of business performance and gain competitive advantage.\n" +
                "\n" +
                "The topics covered in this course include Introduction to Data Science, Analytics in Spreadsheets, Descriptive Statistical Measures, Probability Distributions, Sampling and Estimation, Statistical Inference, Visual Analytics, Linear Regression, Logistic Regression, Classification Trees, Clustering and Segmentation, Dashboards and Communication, Presentations. \n" +
                "\n" +
                "This course will provide students with advanced business analytics methods including predictive analytics and Visual analytics. Both meaningful hands-on experience and case studies describing organisational experiences with business analytics are included. The course has a technical component in which students gain practical knowledge and skills in data mining and visual analytics.", "- Online Quizzes: 20%\n" +
                "- Individual Assignment: 20%\n" +
                "- Group Report and Presentation: 20%\n" +
                "- Final Exam: 40% \n", "This course is only offered in T3", "Please ensure you have completed the following prerequisites: INFS3603"));
        course1.add(new CourseArrayList("Gen Ed #1", "any Faculty", "any General Education course", "General Education", "see Course Outline \n", "any term", "Not Applicable"));
        course1.add(new CourseArrayList("Gen Ed #2", "any Faculty", "any General Education course", "General Education", "see Course Outline \n", "any term", "Not Applicable"));
        course1.add(new CourseArrayList("Free Elective #1", "any Faculty", "any course", "Free Elective", "see Course Outline \n", "any term", "Not Applicable"));
        course1.add(new CourseArrayList("Free Elective #2", "any Faculty", "any course", "Free Elective", "see Course Outline \n", "any term", "Not Applicable"));
        course1.add(new CourseArrayList("Free Elective #3", "any Faculty", "any course", "Free Elective", "see Course Outline \n", "any term", "Not Applicable"));
        course1.add(new CourseArrayList("Free Elective #4", "any Faculty", "any course", "Free Elective", "see Course Outline \n", "any term", "Not Applicable"));

        return course1;
    }

}
