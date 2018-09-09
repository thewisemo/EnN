package com.example.wisemo.placementtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wisemo.placementtest.R;
import com.example.wisemo.placementtest.data.Question;

import java.util.List;

public class QuestionPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Question> mQuestionList;
    private LayoutInflater mLayoutInflater;

    public QuestionPagerAdapter(Context context, List<Question> questionList) {
        mContext = context;
        mQuestionList = questionList;
        mLayoutInflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public QuestionPagerAdapter(){
    }

    public View getView(int position) {
        return null;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        View currentPage = null;
//        switch(position){
//            case 0:
//                currentPage = LayoutInflater.from(context).inflate(R.layout.page0, null)
//                break;
//            case 1:
//                currentPage = LayoutInflater.from(context).inflate(R.layout.page1, null)
//                ///////////// This page will be default ////////////////////
//                ((ViewPager)container).setCurrentItem(position);
//                ////////////////////////////////////////////////////////////
//                break;
//            case 2:
//                currentPage = LayoutInflater.from(context).inflate(R.layout.page2, null)
//                break;
//            return currentPage;
//        }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        View questionView = mLayoutInflater.inflate(R.layout.q_list_item, container, false);

        final TextView questionHeader = questionView.findViewById(R.id.tv_question_header);
        questionHeader.setText(mQuestionList.get(position).getQuestionHeader());

        final TextView firstAnswer = questionView.findViewById(R.id.tv_first_answer);
        firstAnswer.setText(mQuestionList.get(position).getFirstAnswer());

        final TextView secondAnswer = questionView.findViewById(R.id.tv_second_answer);
        secondAnswer.setText(mQuestionList.get(position).getSecondAnswer());

        final TextView thirdAnswer = questionView.findViewById(R.id.tv_third_answer);
        thirdAnswer.setText(mQuestionList.get(position).getThirdAnswer());

        final TextView fourthAnswer = questionView.findViewById(R.id.tv_fourth_answer);
        fourthAnswer.setText(mQuestionList.get(position).getFourthAnswer());

        container.addView(questionView);
        return questionView;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 6;
//        return mQuestionList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public Context getContext() {
        return mContext;
    }

}
