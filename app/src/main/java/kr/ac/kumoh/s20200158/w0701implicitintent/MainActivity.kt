package kr.ac.kumoh.s20200158.w0701implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.s20200158.w0701implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnHomepage.setOnClickListener{
            val uri = Uri.parse("http://www.instagram.com/meizzi_2/")//url(위치 지정)과 uri(이름 정할 떄 사용)
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        binding.btnMap.setOnClickListener{
            val uri = Uri.parse("geo : 0,0?z=17&q=충남 금산군 군청 5길 25")//geo : 36.145014,128.393047?z=17 //geo : 0,0?z=17&q=주소
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if(intent.resolveActivity(packageManager)!=null)
                startActivity(intent)
            else
            {
                Toast.makeText(this, "연결할 앱이 없습니다",
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSms.setOnClickListener{
            val uri = Uri.parse("sms : 010-4165-9078")//url(위치 지정)과 uri(이름 정할 떄 사용)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if(intent.resolveActivity(packageManager)!=null)
                startActivity(intent)
            else
            {
                Toast.makeText(this, "연결할 앱이 없습니다",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}