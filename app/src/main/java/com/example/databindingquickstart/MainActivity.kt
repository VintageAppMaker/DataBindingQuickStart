package com.example.databindingquickstart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.databindingquickstart.databinding.ActivityMainBinding

/*
 MVVM에서 기본적으로 사용하는 ViewModel과 DataBinding을
 직관적으로 이해하기 위해만든 초간단 예제
 app의 build.gradle 설정 중요함

* */
class MainActivity : AppCompatActivity() {

    lateinit var binder : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // 1. View Model을 이용한 LiveData처리
        val viewModelTest =  ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModelTest.sMessage.observe(this, Observer<String> {

            // 바인딩된 bindData에 값을 넣었을 때...
            var b = binder.bindData
            binder.bindData = b?.apply {showMessage = it }


            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        })

        // 2. XML과 데이터를 바인딩하는 DataBinding
        binder = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binder.bindData = BindData().apply {
            showMessage = "Bind Test"
        }


        binder.edtMessage.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // viewModelTest의 sMessage의 값을 넣었을 때,
                // .value에 유의
                viewModelTest.sMessage.value = s.toString()

            }
        })


    }
}
