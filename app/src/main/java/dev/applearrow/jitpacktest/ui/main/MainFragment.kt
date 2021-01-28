package dev.applearrow.jitpacktest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.applearrow.jitpacktest.databinding.MainFragmentBinding
import dev.applearrow.logcat.LogCatCollector
import timber.log.Timber

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        const val LOG_START = "myLogs"
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        Timber.d(LOG_START)
        Timber.d("hello there")
        Timber.i("hi again")
        Timber.d("good bye")
        binding.message.text =
            LogCatCollector("MainFragment").collect(LOG_START, true, listOf("good"))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}