package com.mercuryirc.client;

import com.mercuryirc.client.protocol.model.*;
import com.mercuryirc.client.protocol.network.Connection;
import com.mercuryirc.client.protocol.network.callback.IrcCallback;
import com.mercuryirc.client.ui.ApplicationPane;
import com.mercuryirc.client.ui.Tab;
import com.mercuryirc.client.ui.model.MessageRow;
import javafx.application.Platform;

import java.util.List;
import java.util.Set;

public class MercuryCallback implements IrcCallback {

	private ApplicationPane appPane;

	public MercuryCallback(ApplicationPane appPane) {
		this.appPane = appPane;
	}

	public void onConnect(Connection connection) {
		connection.joinChannel("#mercury");
	}

	@Override
	public void onMessage(final Connection connection, final Message message) {
		Platform.runLater(new Runnable() {
			public void run() {
				Target target = connection.resolveTarget(message.getTarget());
				MessageRow row = new MessageRow(connection, message);
				Tab tab = appPane.getTabPane().getTab(target);
				tab.getMessagePane().addRow(row);
			}
		});
	}

	@Override
	public void onChannelJoin(Connection connection, Channel channel, User user) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onChannelPart(Connection connection, Channel channel, User user, String reason) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onUserQuit(Connection connection, User user, String reason) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onChannelNickList(Connection connection, Channel channel, Set<String> nicks) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onTopicChange(Connection connection, Channel channel, String who) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onUserNickChange(Connection connection, User user, String oldNick) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onUserKick(Connection connection, Channel channel, User user, String reason) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void onChannelModeList(Connection connection, Channel channel, Mode.Type type, List<Mode> list) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

}