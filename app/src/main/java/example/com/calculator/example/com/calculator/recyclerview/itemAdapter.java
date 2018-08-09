package example.com.calculator.example.com.calculator.recyclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import example.com.calculator.Contacts.CallPhoneActivity;
import example.com.calculator.Contacts.ContactActivity;
import example.com.calculator.FilePersistence.DatabaseActivity;
import example.com.calculator.FilePersistence.FilePersistenceActivity;
import example.com.calculator.LitePal.LitePalActivity;
import example.com.calculator.other.LifeActivity;
import example.com.calculator.other.Main2Activity;
import example.com.calculator.other.MainActivity;
import example.com.calculator.R;
import example.com.calculator.broadcast.BroadcastMainActivity;

/**
 * Created by 钱俊华 on 2018/7/16 0016.
 */

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    private List<item> mData;
    //构造函数
    public itemAdapter(List<item> Data) {
        this.mData = Data;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                item item = mData.get(position);
                Toast.makeText(v.getContext(),item.getName(),Toast.LENGTH_SHORT).show();
                Intent intent;
                switch (item.getName()){
                    case "计算器":
                        intent = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "登录界面":
                        intent = new Intent(v.getContext(), Main2Activity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "LifeActivity":
                        intent = new Intent(v.getContext(), LifeActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "广播机制":
                        intent = new Intent(v.getContext(), BroadcastMainActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "IO流":
                        intent = new Intent(v.getContext(), FilePersistenceActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "Database":
                        intent = new Intent(v.getContext(), DatabaseActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "LitePal":
                        intent = new Intent(v.getContext(), LitePalActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "内容提供器":
                        intent = new Intent(v.getContext(), CallPhoneActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                    case "获取联系人信息":
                        intent = new Intent(v.getContext(), ContactActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                }
/*                if(item.getName() == "C") {
                    intent = new Intent(v.getContext(), LifeActivity.class);
                    v.getContext().startActivity(intent);
                }*/
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        item item = mData.get(position);
        holder.Name.setText(item.getName());
        //holder.imageId.setImageResource(item.getImageId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //内部类
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Name;
        //private ImageView imageId;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            Name = (TextView) itemView.findViewById(R.id.item_text);
            //imageId = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
