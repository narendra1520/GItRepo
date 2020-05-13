package com.example.gitrepo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitrepo.api.GitRepoResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueViewHolder>{

    List<GitRepoResponse> issueList;
    Context context;

    public IssueAdapter(List<GitRepoResponse> issueList, Context context) {
        this.issueList = issueList;
        this.context = context;
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_issues, parent, false);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {
        GitRepoResponse issue = issueList.get(position);
        holder.repo_url.setText(issue.getRepository_url());
        holder.user_id.setText(issue.getUser().getId());
        holder.user_login.setText(issue.getUser().getLogin());

        if(issue.getState().equalsIgnoreCase("open"))
            holder.chk_state.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

    class IssueViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_url)
        TextView repo_url;
        @BindView(R.id.user_id)
        TextView user_id;
        @BindView(R.id.user_login)
        TextView user_login;

        @BindView(R.id.chk_state)
        CheckBox chk_state;

        IssueViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
