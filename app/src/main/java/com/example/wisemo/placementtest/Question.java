package com.example.wisemo.placementtest;

public class Question {

    private String mUserName;
    private String mUserPhone;
    private String mUserEmail;

    private int mUserScore;

    private String mQuestionHeader;
    private String mFirstAnswer;
    private String mSecondAnswer;
    private String mThirdAnswer;
    private String mFourthAnswer;

    private boolean mFirstIsRight = true;
    private boolean mSecondIsRight = true;
    private boolean mThirdIsRight = true;
    private boolean mFourthIsRight = true;

    // Question "Answers types" constructors
    public Question(){}

    public Question (String questionHeader,
                     String firstAnswer, boolean firstIsRight,
                     String secondAnswer,
                     String thirdAnswer,
                     String fourthAnswer) {
        mQuestionHeader = questionHeader;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
        mThirdAnswer = thirdAnswer;
        mFourthAnswer = fourthAnswer;
        mFirstIsRight = firstIsRight;
    }

    public Question (String questionHeader,
                     String firstAnswer,
                     String secondAnswer, boolean secondIsRight,
                     String thirdAnswer,
                     String fourthAnswer) {
        mQuestionHeader = questionHeader;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
        mThirdAnswer = thirdAnswer;
        mFourthAnswer = fourthAnswer;
        mSecondIsRight = secondIsRight;
    }

    public Question (String questionHeader,
                     String firstAnswer,
                     String secondAnswer,
                     String thirdAnswer, boolean thirdIsRight,
                     String fourthAnswer) {
        mQuestionHeader = questionHeader;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
        mThirdAnswer = thirdAnswer;
        mFourthAnswer = fourthAnswer;
        mThirdIsRight = thirdIsRight;
    }

    public Question (String questionHeader,
                     String firstAnswer,
                     String secondAnswer,
                     String thirdAnswer,
                     String fourthAnswer, boolean fourthIsRight) {
        mQuestionHeader = questionHeader;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
        mThirdAnswer = thirdAnswer;
        mFourthAnswer = fourthAnswer;
        mFourthIsRight = fourthIsRight;
    }

    // Getter methods
    public String getQuestionHeader() {
        return mQuestionHeader;
    }

    public String getFirstAnswer() {
        return mFirstAnswer;
    }

    public String getSecondAnswer() {
        return mSecondAnswer;
    }

    public String getThirdAnswer() {
        return mThirdAnswer;
    }

    public String getFourthAnswer() {
        return mFourthAnswer;
    }

    public boolean isFirstIsRight() {
        return mFirstIsRight;
    }

    public boolean isSecondIsRight() {
        return mSecondIsRight;
    }

    public boolean isThirdIsRight() {
        return mThirdIsRight;
    }

    public boolean isFourthIsRight() {
        return mFourthIsRight;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getUserPhone() {
        return mUserPhone;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public int getUserScore(){
        return mUserScore;
    }

    // Setters methods
    public void setQuestionHeader(String questionHeader) {
        mQuestionHeader = questionHeader;
    }

    public void setFirstAnswer(String firstAnswer) {
        mFirstAnswer = firstAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        mSecondAnswer = secondAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        mThirdAnswer = thirdAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        mFourthAnswer = fourthAnswer;
    }

    public void setFirstIsRight(boolean firstIsRight) {
        mFirstIsRight = firstIsRight;
    }

    public void setSecondIsRight(boolean secondIsRight) {
        mSecondIsRight = secondIsRight;
    }

    public void setThirdIsRight(boolean thirdIsRight) {
        mThirdIsRight = thirdIsRight;
    }

    public void setFourthIsRight(boolean fourthIsRight) {
        mFourthIsRight = fourthIsRight;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public void setUserPhone(String userPhone) {
        mUserPhone = userPhone;
    }

    public void setUserEmail(String userEmail) {
        mUserEmail = userEmail;
    }

    public void setUserScore(int userScore){
        mUserScore = userScore;
    }
}