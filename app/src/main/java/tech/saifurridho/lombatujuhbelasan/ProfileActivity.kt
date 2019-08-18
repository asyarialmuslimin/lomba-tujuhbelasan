package tech.saifurridho.lombatujuhbelasan

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ibtnEmail: Button
    private lateinit var ibtnGithub:Button
    private lateinit var ibtnIg:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Profile")

        ibtnEmail = findViewById(R.id.btnEmail)
        ibtnGithub = findViewById(R.id.btnGithub)
        ibtnIg = findViewById(R.id.btnIg)

        ibtnEmail.setOnClickListener(this)
        ibtnGithub.setOnClickListener(this)
        ibtnIg.setOnClickListener(this)

    }

    override fun onSupportNavigateUp() : Boolean {
        finish()
        return true
    }

    override fun onClick(v: View?) {
        when(v?.getId()){
            R.id.btnEmail -> {
                val mailto = "mailto:saifurridho1208@gmail.com?subject=Halo&body=Hai%20ini%20pesan%20dari%20Aplikasimu"
                var gmail = Intent(Intent.ACTION_SENDTO).setData(Uri.parse(mailto))
                startActivity(gmail)

            }
            R.id.btnGithub -> {
                var github = Intent(Intent.ACTION_VIEW)
                github.setData(Uri.parse("https://github.com/asyarialmuslimin"))
                startActivity(github)
            }
            R.id.btnIg -> {
                var insta = Intent(Intent.ACTION_VIEW)
                insta.setData(Uri.parse("https://www.instagram.com/saifur.ridlo/"))
                startActivity(insta)
            }
        }
    }
}
