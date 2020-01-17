package minerva.android.services

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.service_list_row.view.*
import minerva.android.R
import minerva.android.walletmanager.model.Service
import minerva.android.walletmanager.storage.ServiceType

class ServicesAdapter : RecyclerView.Adapter<ServiceViewHolder>() {

    private var services = listOf<Service>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder =
        ServiceViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.service_list_row, parent, false), parent)

    override fun getItemCount(): Int = services.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bindData(services[position])
    }

    fun updateList(services: List<Service>) {
        this.services = services
        notifyDataSetChanged()
    }
}

class ServiceViewHolder(private val view: View, private val viewGroup: ViewGroup) : RecyclerView.ViewHolder(view) {
    fun bindData(service: Service) {
        view.apply {
            if (service.type == ServiceType.MINERVA) {
                Glide.with(viewGroup.context).load(R.drawable.ic_minerva_icon).into(serviceLogo)
            }
            serviceName.text = service.name
            lastUsed.text = "${context.getString(R.string.last_used)} ${service.lastUsed}"
        }
    }
}