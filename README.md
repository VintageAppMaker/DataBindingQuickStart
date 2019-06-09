# DataBindingQuickStart
UltraQuick DataBinding &amp; ViewModel경험하기 

> MVVM의 기본이 되는 LiveData, ViewModel, DataBinding을 직관적으로 이해하기 위한 소스 

~~~
app의 build.gradle에서 

plugin에서 다음추가 
apply plugin: 'kotlin-kapt'

...

dependencies에서 다음추가  

kapt "com.android.databinding:compiler:3.0.1"

dataBinding {
    enabled = true
}

~~~

DataBinding

- XML에서는 layout으로 시작하고 그 안에 data와 view를 분리한다. 

~~~xml

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
>
    <data>
        <variable
                name="BindData"
                type="com.example.databindingquickstart.BindData" />

    </data>

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
    >

        <TextView
                android:id="@+id/txt_title"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="16dp"
                android:text="@{BindData.showMessage}"
        />

        <TextView
                android:id="@+id/txt_title2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="#FF0000"
                android:padding="16dp"
                android:text="@{BindData.showMessage}"
        />

        <TextView
                android:id="@+id/txt_title3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="#00BCD4"
                android:padding="16dp"
                android:text="@{BindData.showMessage}"
        />

        <EditText
                android:id="@+id/edt_message"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>

    </LinearLayout>

</layout>

~~~

빌드가 안될 시

1. File  -> Invalidate Caches / Restart
2. Build -> Clean Project
3. Build -> Rebuild Project
4. Run & Debug시에 빌드가 안되면 File -> Settings에서 Instant Run을 비활성화
