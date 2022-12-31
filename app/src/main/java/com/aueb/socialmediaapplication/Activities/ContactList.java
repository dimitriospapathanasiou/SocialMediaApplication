package com.aueb.socialmediaapplication.Activities;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.aueb.socialmediaapplication.Database.PseudoDatabase;
import com.aueb.socialmediaapplication.Database.UserDatabase;
import com.aueb.socialmediaapplication.Entities.User;
import com.aueb.socialmediaapplication.R;
import
        com.aueb.socialmediaapplication.databinding.LayoutActivityContactlistBinding;
import java.util.List;
public class ContactList extends AppCompatActivity implements
        ContactInterface{
    LayoutActivityContactlistBinding binding;
    SearchUsers presenter;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.layout_activity_contactlist);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        password = extras.getString("password");
        UserDatabase userDb = PseudoDatabase.fillWithUsers();
        presenter = new SearchUsers(this, userDb);
        setUpRecyclerView();
        User user = UserDatabase.getUserFromCredentials(username,password);
        presenter.loadUsers(user);
    }
    private void setUpRecyclerView() {
        binding.contacts.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void showUsers(List<User> userList) {
        binding.contacts.setAdapter(new ContactListAdapter(userList, this));
    }
}