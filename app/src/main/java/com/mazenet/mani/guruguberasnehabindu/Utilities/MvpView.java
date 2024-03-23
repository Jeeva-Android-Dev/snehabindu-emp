package com.mazenet.mani.guruguberasnehabindu.Utilities;



public interface MvpView {

    void showProgressDialog();

    void hideProgressDialog();

    void showDialogWithError(int errorCode, String error);

    void showNetWorkError();


}
