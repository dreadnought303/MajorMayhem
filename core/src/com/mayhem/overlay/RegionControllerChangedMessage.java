package com.mayhem.overlay;

import java.util.Iterator;

import rice.p2p.commonapi.Id;

//This message will send to a node which is responsible for a specific region
//and this node will maintain a list of [regionID,RC] 
public class RegionControllerChangedMessage extends Message {

	private static final long serialVersionUID = 7114773048475928706L;
	private Id regionId, coordinatorId;

	public RegionControllerChangedMessage(Id sender, Id receiver, Id regionId,
			Id coordinatorId) {
		super(sender, receiver);
		this.regionId = regionId;
		this.coordinatorId = coordinatorId;
	}

	@Override
	public void execute(ClientApplication app) {
		System.out.println("Save RC:" + coordinatorId + ", regionId:"
				+ regionId);
		//it has to be removed from the list beforehand if RC was responsible for another region
		if (app.coordinatorList.containsValue(coordinatorId)) {
			Iterator<Id> itr = app.coordinatorList.keySet().iterator();
			Id region = null;
			while (itr.hasNext()) {
				Id tmp = itr.next();
				if (coordinatorId == app.coordinatorList.get(tmp))
					region = tmp;
			}
			if (region != null)
				app.coordinatorList.remove(region);
		}

		app.coordinatorList.put(regionId, coordinatorId);
	}
}
