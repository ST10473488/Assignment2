package vcmsa.ci.quizapp;

import android.app.Activity;

public class quizActivity extends Activity {
}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:id="@+id/quiz_layout"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:gravity="center"
android:padding="24dp"
android:background="#FFFFFF">

    <TextView
android:id="@+id/questionTextView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Question goes here"
android:textSize="20sp"
android:textColor="#000000"
android:gravity="center"
android:layout_marginBottom="24dp" />

    <Button
android:id="@+id/trueButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="True"
android:backgroundTint="#4CAF50"
android:textColor="#FFFFFF"
android:layout_marginBottom="12dp" />

    <Button
android:id="@+id/falseButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="False"
android:backgroundTint="#F44336"
android:textColor="#FFFFFF"
android:layout_marginBottom="24dp" />

    <TextView
android:id="@+id/feedbackTextView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text=""
android:textSize="16sp"
android:textColor="#000000"
android:layout_marginBottom="24dp" />

    <Button
android:id="@+id/nextButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Next"
android:backgroundTint="#6200EE"
android:textColor="#FFFFFF"
android:enabled="false" />
</LinearLayout>