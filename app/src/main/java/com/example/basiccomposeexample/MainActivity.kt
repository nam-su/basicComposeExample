package com.example.basiccomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccomposeexample.ui.theme.BasicComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeExampleTheme {

                Greeting()

            }
        }
    }
}

// Composable 이 View라고 생각하면 간단하다.
// modifier 는 뷰의 여러 속성을 다루는 객체
@Composable
fun Greeting(modifier: Modifier = Modifier) {

    // true false 를 담을 변수
    // 이 변수를 텍스트뷰가 감지해서 변수에 따라 값이 변한다.
    var changeText by remember { mutableStateOf(false) }

    // Column -> View 를 세로로 놓는 함수
    Column(modifier = Modifier

        // fillMaxSize() -> match_parent의 역할
        .fillMaxSize()

        // 수평정렬 속성

        , horizontalAlignment = Alignment.CenterHorizontally,

        // 수직정렬 속성
          verticalArrangement = Arrangement.Center) {

        // 텍스트뷰 선언 및 초기화
        Text(

            // changeText 변수의 값에 따라 text 값을 지정
            text = if(!changeText) "바뀌기 전 텍스트" else "바뀐 후 텍스트",

            // 텍스트의 정렬을 위해서 가로길이를 최대로
            modifier = Modifier.fillMaxWidth(),

            // 텍스트 가운데 정렬
            textAlign = TextAlign.Center,

        )

        // 버튼 선언 및 초기화
        // 클릭 했을때 changeText 변수 true , false로 바꿔줌
        Button(onClick = { changeText = !changeText },

            // 일반 xml과는 다르게 여기서는 padding 이 margin의 역할을 함.
            // xml처럼 padding을 주기위해서는 contentPadding 사용
            modifier = Modifier.padding(40.dp)) {

            // button의 텍스트
            Text("텍스트 변경")

        }

    }

}

// 미리보기
// showBackground 속성을 이용하면 배경화면이 있는 상태로 미리보기 볼 수 있음
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    BasicComposeExampleTheme {
        Greeting()
    }

}