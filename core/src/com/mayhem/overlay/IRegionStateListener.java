package com.mayhem.overlay;

import java.util.*;

public interface IRegionStateListener {
	public void regionStateReceived(List<PlayerState> playerList,
			List<BombState> bombList);
}