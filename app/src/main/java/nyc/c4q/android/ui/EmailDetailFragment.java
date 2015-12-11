package nyc.c4q.android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import nyc.c4q.android.R;
import nyc.c4q.android.model.Email;

public class EmailDetailFragment extends Fragment {
  private Email email;
  private static final DateFormat formatter = SimpleDateFormat.getDateInstance(DateFormat.SHORT);

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    email = (Email) getArguments().getSerializable("email");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_email_detail, container, false);

    // TODO - get references to views
    ImageView senderPic = (ImageView)view.findViewById(R.id.email_from_img);
    TextView fromName = (TextView)view.findViewById(R.id.email_from);
    TextView subject = (TextView)view.findViewById(R.id.email_subject);
    TextView sent = (TextView)view.findViewById(R.id.email_sent);
    TextView body = (TextView)view.findViewById(R.id.email_body);
    body.setMovementMethod(new ScrollingMovementMethod());

    // TODO - replace nulls
    Picasso.with(getActivity()).load(email.getFromUrl()).into(senderPic);

    // TODO - bind email data to views
    fromName.setText(email.getFrom());
    subject.setText(email.getSubject());
    sent.setText(String.valueOf(email.getSent()));
    body.setText(email.getBody());

    return view;
  }

  public static EmailDetailFragment newInstance(Email email) {
    // TODO - implement this factory method
    // create fragment, set up its only argument (the email) and return it

    // hint
    //args.putSerializable("email", email);

    EmailDetailFragment newFragment = new EmailDetailFragment();

    Bundle args = new Bundle();
    args.putSerializable("email", email);
    newFragment.setArguments(args);

    return newFragment;


  }
}
