package com.example.gamejanken

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.findViewTreeViewModelStoreOwner


class GameActivity {

    private  lateinit var computerImageView: ImageView
    private lateinit var satuImageButton: ImageButton
    private lateinit var duaImageButton: ImageButton
    private lateinit var tigaImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        satuImageButton = findViewById(R.id.satuImageButton)
        duaImageButton = findViewById(R.id.satuImageButton)
        tigaImageButton = findViewById(R.id.tigaImageButton)
        resultImageView = findViewById(R.id.resultImageView)

    }
    private fun initListeners(){
        satuImageButton.setOnClickListener { startGame( "ROCK" ) }
        duaImageButton.setOnClickListener { starGame ("SCISSORS") }
        tigaImageButton.setOnClickListener { startGame ("PAPER") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }
}