package com.example.menus

import android.Manifest.permission.CALL_PHONE
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),PopupMenu.OnMenuItemClickListener {

    lateinit var  txt2: TextView
    lateinit var txt3:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt2 =findViewById(R.id.txt2)
        txt3 = findViewById(R.id.txt3)

  // Allow Permission Code symbol ave Allow and Don't Allow :

        if (checkSelfPermission(CALL_PHONE)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)
        }


        //Context OnCreate Passing

        registerForContextMenu(txt2)

        // popupMenu
        txt3.setOnClickListener {

            var popup = PopupMenu(applicationContext,txt3)
            popup.menuInflater.inflate(R.menu.poppup_menu,popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()

        }

    }

    // option Collection item menu
    //licking on the menu shows the option menu items on which we can perform the relevant action.

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId)
        {
            R.id.item->
            {
             Toast.makeText(applicationContext,"Clicked message",Toast.LENGTH_SHORT).show()
            }
            R.id.item1->
            {
                finishAffinity()
            }
            R.id.item3->
            {

            }


        }
        return super.onOptionsItemSelected(item)
    }

    // Context menu LogTime Clicked an item open thy
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {


        menuInflater.inflate(R.menu.context_menu,menu)

        super.onCreateContextMenu(menu, v, menuInfo)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
           R.id.cnt->
           {
               Toast.makeText(applicationContext,"Call",Toast.LENGTH_SHORT).show()
           }

        }

        return super.onContextItemSelected(item)
    }

   // Android Popup Menu is a list menu that appears vertically to the view
    // we will add the popup menu items on a view (button).
    // Clicking on the button shows the popup menu items on which we can perform the relevant action.
    //PopupMenu.OnMenuItemClickListener interface receives the menu items
   // click events if the items don't have their click listener.

    override fun onMenuItemClick(p0: MenuItem?): Boolean {

        when(p0!!.itemId){

             R.id.i1->
             {
                 Toast.makeText(applicationContext,"Data Called",Toast.LENGTH_LONG).show()
             }


        }
        return false
    }



}