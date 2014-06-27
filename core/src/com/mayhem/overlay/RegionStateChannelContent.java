package com.mayhem.overlay;

import java.util.List;
import rice.p2p.commonapi.Id;

public class RegionStateChannelContent extends ChannelContent {
	private static final long serialVersionUID = 2522899394681916995L;

	private Region region;

	public RegionStateChannelContent(Region region, Id sender) {
		super(sender);
		this.region = region;
	}

	public Region getRegion() {
		return this.region;
	}

	public String toString() {
		String result = "";

		// if (playerList != null)
		// for (PlayerState player : this.playerList) {
		// result += player.getId() + "(" + player.getX() + ","
		// + player.getY() + "), ";
		// }

		return result;
	}
}
