package com.example.categorieslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), categoryAdapter.OnItemClickListener{

  private val  listEntries= ArrayList<Entrie>()




    override fun onItemClick(position: Int) {
        val (API,Description,Auth, HTTPS,Cors,Link)=listEntries[position]
        val enviar = Intent(this, Attributes::class.java)
        enviar.putExtra("API",API)
        enviar.putExtra("Description",Description)
        enviar.putExtra("Auth",Auth)
        enviar.putExtra("HTTPS",HTTPS.toString())
        enviar.putExtra("Cors",Cors)
        enviar.putExtra("Link",Link)
        startActivity(enviar)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        getCall()

    }




    private fun getRetrofit():Retrofit{
         return Retrofit.Builder().baseUrl("https://api.publicapis.org/")
             .addConverterFactory(GsonConverterFactory.create()).build()
     }

  private fun getCall(){

      CoroutineScope(Dispatchers.IO).launch {
          val call= getRetrofit().create(ServiceAPI::class.java).getResponse("entries")
          val calling= call.body()


          runOnUiThread {
              val recycler=findViewById<RecyclerView?>(R.id.recycler)
              val swiper:SwipeRefreshLayout = findViewById(R.id.swiper)

              if(call.isSuccessful){

               val categories= calling?.entries ?: emptyList()
                  var from=0

                  fun cargarDatos():ArrayList<Entrie>{
                      val data=ArrayList<Entrie>()

                          for (item in from .. from+ 30){
                              data.add(categories[item])

                             from=item
                          }



                      return data
                  }

                  swiper.setOnRefreshListener {Toast.makeText(this@MainActivity, "Refrescando", Toast.LENGTH_SHORT).show()

                       listEntries.addAll(cargarDatos())
                      recycler.adapter?.notifyDataSetChanged()
                      swiper.isRefreshing=false
                  }



                  listEntries.clear()
                  listEntries.addAll(cargarDatos())
                  recycler.adapter=categoryAdapter(listEntries, this@MainActivity)

              }else{showError()}

          }

      }

  }



    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }




}