package tiki.com.keyword.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_keyword.*
import tiki.com.keyword.R
import tiki.com.keyword.adapter.KeywordAdapter
import tiki.com.keyword.viewmodel.KeywordViewModel

class KeywordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyword)

        setupViewModel()
    }

    private fun setupViewModel() {
        val viewModel = ViewModelProviders.of(this).get(KeywordViewModel::class.java)
        viewModel.loadKeyword()
        setObserveLive(viewModel)
    }

    private fun setObserveLive(viewModel: KeywordViewModel) {
        viewModel.eventSuccess.observe(this, Observer {listKeyword ->
            recycler_view.apply {
                layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                adapter = listKeyword?.let { KeywordAdapter(it) }
            }
        })

        viewModel.eventLoading.observe(this, Observer { isShow ->
            progress_loading.visibility = if (isShow == true) View.VISIBLE else View.GONE
        })

        viewModel.eventFailure.observe(this, Observer {error->
            text_error.visibility = View.VISIBLE
            text_error.text = error?.message
        })
    }
}
