package demo;

import ratpack.handling.ChainAction;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class Routes extends ChainAction {
	@Override
	protected void execute() throws Exception {
		handler("google", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				context.redirect("http://google.com");
			}
		});

		get("yahoo", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				context.redirect("http://yahoo.com");
			}
		});

		get("foo", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				context.getResponse().send("At foo.");
			}
		});

		assets("public", "index.html");
	}
}