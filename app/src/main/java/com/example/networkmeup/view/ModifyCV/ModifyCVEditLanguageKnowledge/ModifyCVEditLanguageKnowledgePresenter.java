package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge;

public class ModifyCVEditLanguageKnowledgePresenter {

    private ModifyCVEditLanguageKnowledgeView view;
    private String userToken;

    public ModifyCVEditLanguageKnowledgePresenter(ModifyCVEditLanguageKnowledgeView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onItemClick(int position){
        view.changeLanguageKnowledgeDetails(userToken, position);
    }

    public void onAddNew() {
        view.addNewLanguageKnowledge(userToken);
    }
}
