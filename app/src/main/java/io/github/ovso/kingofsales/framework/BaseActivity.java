package io.github.ovso.kingofsales.framework;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.ovso.kingofsales.R;

public abstract class BaseActivity extends AppCompatActivity {
  protected @BindView(R.id.toolbar) Toolbar toolbar;
  private Unbinder unbinder;

  protected abstract @LayoutRes int getLayoutResId();

  protected abstract void onCreated();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());
    unbinder = ButterKnife.bind(this);
    setupToolbar();
    onCreated();
  }

  private void setupToolbar() {
    setSupportActionBar(toolbar);
  }

  @Override protected void onDestroy() {
    unbinder.unbind();
    super.onDestroy();
  }
}
