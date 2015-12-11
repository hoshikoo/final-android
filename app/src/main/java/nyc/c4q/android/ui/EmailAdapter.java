package nyc.c4q.android.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nyc.c4q.android.R;
import nyc.c4q.android.model.Email;

public class EmailAdapter extends BaseAdapter {
  private static final int MAX_BODY_LENGTH = 20;

  private final Context context;
  private final LayoutInflater inflater;
  private List<Email> emails;

  public EmailAdapter(Context context, List<Email> emails) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
    this.emails = emails;
  }



  @Override public int getCount() {
    return emails.size();
  }

  @Override public Email getItem(int position) {
    return emails.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View getView(int position, View view, ViewGroup parent) {

    EmailViewHolder mViewHolder;

    if (view == null) {
      // TODO - load R.layout.list_email_row
      view = inflater.inflate(R.layout.list_email_row, parent, false);

    }

    // TODO - setup views
    mViewHolder = new EmailViewHolder(view);

    // TODO - get the email defined at 'position'

    Email email = emails.get(position);


    // TODO - replace nulls
    Picasso.with(context)
        .load(email.getFromUrl())
        .placeholder(R.mipmap.ic_launcher)
        .resizeDimen(R.dimen.list_image_size, R.dimen.list_image_size)
        .centerCrop()
        .into(mViewHolder.mPicImage);

    // TODO - set up other views
    // for body, only use MAX_BODY_LENGTH chars followed by "..."
    mViewHolder.mEmailSubject.setText(email.getSubject());
    mViewHolder.mEmailBody.setText(email.getSubject());

    return view;
  }

  private class EmailViewHolder {

    ImageView mPicImage;
    TextView mEmailSubject;
    TextView mEmailBody;

    public EmailViewHolder(View item) {

      mPicImage = (ImageView) item.findViewById(R.id.email_from_img);

      mEmailSubject = (TextView) item.findViewById(R.id.email_subject);
      mEmailBody = (TextView) item.findViewById(R.id.email_body);
    }
  }
}
