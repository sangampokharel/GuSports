package com.example.gusports.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gusports.R
import com.example.gusports.models.Rules
import com.example.gusports.utils.Pdf
import com.example.gusports.utils.Resource
import com.example.gusports.viewmodels.RulesActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_rules_details.*


@AndroidEntryPoint
class RulesDetailsActivity : AppCompatActivity() {

private val rulesActivityViewModel by  viewModels<RulesActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules_details)

        rules_back_btn.setOnClickListener {
            finish()
        }




        if(intent.hasExtra("category"))
        {

            rulesActivityViewModel.getRules(intent.getStringExtra("category")!!)
            rules_detail_title.text = intent.getStringExtra("title")


        }

        rulesActivityViewModel.rules.observe(this) {
            when (it) {
                is Resource.Success -> {
                    Pdf(pdfView, rulesProgress).execute(it.data.pdfUrl)

                    rulesProgress.visibility = View.INVISIBLE
                }

                is Resource.Loading -> {
                    rulesProgress.visibility = View.VISIBLE
                }
                is Resource.Failure -> {
                    Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()

                    rulesProgress.visibility = View.INVISIBLE
                }

            }
        }


    }

}