package com.gh4a.loader;

import java.io.IOException;

import org.eclipse.egit.github.core.RepositoryCommitCompare;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.CommitService;

import android.content.Context;

import com.gh4a.Gh4Application;

public class CommitCompareLoader extends BaseLoader<RepositoryCommitCompare> {

    private String mRepoOwner;
    private String mRepoName;
    private String mBase;
    private String mHead;

    public CommitCompareLoader(Context context, String repoOwner, String repoName,
            String base, String head) {
        super(context);
        mRepoOwner = repoOwner;
        mRepoName = repoName;
        mBase = base;
        mHead = head;
    }

    @Override
    public RepositoryCommitCompare doLoadInBackground() throws IOException {
        CommitService commitService = (CommitService)
                Gh4Application.get(getContext()).getService(Gh4Application.COMMIT_SERVICE);
        return commitService.compare(new RepositoryId(mRepoOwner, mRepoName), mBase, mHead);
    }
}
