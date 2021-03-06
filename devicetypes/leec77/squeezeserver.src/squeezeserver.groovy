/**
 *  Squeeze Server
 *
 *  Copyright 2014 Mike Maxwell
 *  Orginal update by Lee Charlton to handle volume control, status refresh, sync and unsync and playlists.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 

preferences {
		// Player mac adddresses, for each required player
		input("confp1", "string", title:"Enter Player 1 MAC",defaultValue:"00:00:00:00:00:00", required:true, displayDuringSetup:true)
    	input("confp2", "string", title:"Enter Player 2 MAC",defaultValue:"00:00:00:00:00:00", required:true, displayDuringSetup:true)
    	input("confp3", "string", title:"Enter Player 3 MAC",defaultValue:"00:00:00:00:00:00", required:true, displayDuringSetup:true)
    	input("confp4", "string", title:"Enter Player 4 MAC",defaultValue:"00:00:00:00:00:00", required:true, displayDuringSetup:true)
    	input("confp5", "string", title:"Enter Player 5 MAC",defaultValue:"00:00:00:00:00:00", required:true, displayDuringSetup:true)
        
    	// List of players in sync group 1
    	input("syc1play1", "ENUM",  title:"Sync Grp 1 master player", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc1play2", "ENUM",  title:"Sync Grp 1 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
    	input("syc1play3", "ENUM",  title:"Sync Grp 1 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc1play4", "ENUM",  title:"Sync Grp 1 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc1play5", "ENUM",  title:"Sync Grp 1 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        // List of players in sync group 2
        input("syc2play1", "ENUM",  title:"Sync Grp 2 master player", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc2play2", "ENUM",  title:"Sync Grp 2 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
    	input("syc2play3", "ENUM",  title:"Sync Grp 2 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc2play4", "ENUM",  title:"Sync Grp 2 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc2play5", "ENUM",  title:"Sync Grp 2 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        // List of players in sync group 3
		input("syc3play1", "ENUM",  title:"Sync Grp 3 master player", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc3play2", "ENUM",  title:"Sync Grp 3 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
    	input("syc3play3", "ENUM",  title:"Sync Grp 3 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc3play4", "ENUM",  title:"Sync Grp 3 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        input("syc3play5", "ENUM",  title:"Sync Grp 3 player to sync", options:["player 1","player 2","player 3","player 4","player 5"],displayDuringSetup:true)
        // List of playerlists as they appear in SB Players
        input("playlist1", "string", title: "Enter playlist 1 name", displayDuringSetup:true)
        input("playlist2", "string", title: "Enter playlist 2 name", displayDuringSetup:true)
        input("playlist3", "string", title: "Enter playlist 3 name", displayDuringSetup:true)
        input("playlist4", "string", title: "Enter playlist 4 name", displayDuringSetup:true)
        input("playlist5", "string", title: "Enter playlist 5 name", displayDuringSetup:true)
                
}

metadata {
	definition (name: "squeezeServer", namespace: "LeeC77", author: "Lee Charlton") {

        capability "Switch"
        capability "Refresh"

        
    	//custom attributes to control sync groups of players
        attribute "syncswitch1", "enum", ["synced", "unsynced"]
        attribute "syncswitch2", "enum", ["synced", "unsynced"]
        attribute "syncswitch3", "enum", ["synced", "unsynced"]
        attribute "scanstate", "string"
       
        //custom commands for multiple players
        //use the standard (built in on/off) if you only have one player
        command "p1On"
        command "p1Off"
        command "p2On"
        command "p2Off"
        command "p3On"
        command "p3Off"
        command "p4On"
        command "p4Off"
        command "p5On"
        command "p5Off"
        // custom command to allow sync on player groups
        command "syncG1" 
        command "syncG2"
        command "syncG3" 
        command "unsyncAll"
        // custom command to refresh
        command "p1refresh"
        command "p2refresh"
        command "p3refresh"
        command "p4refresh"
        command "p5refresh"
        command "allrefresh"
        // custom commands for volume up and down
        command "p1Volup"
        command "p1Voldn"
        command "p2Volup"
        command "p2Voldn"
        command "p3Volup"
        command "p3Voldn"
        command "p4Volup"
        command "p4Voldn"
        command "p5Volup"
        command "p5Voldn"
        // custom commands for play list picker.
        command "playlistPicker"
        command "playerPicker"
        command "playlistApply"
        command "serverlistenon"  //turn on  real time listen to SB server
        command "serverlistenoff" //turn on  real time listen to SB server
        command "lock"
        command "unlock"
        
        //enable ' command "getNID" ' and use to create the hex version of your squeeze servers CLI interface
        //ip address and port, this will need to be assigned to the "Device Network Id" field
        //after the device is added to your system.
        
        // custom command to allow the integration of responses from the player (via JSON)
        command "SBSResp", ["string"]

	}

	simulator {
		// TODO: define status and reply messages here
	}

	tiles(scale: 2) {
		       
		standardTile("syncGrp1", "device.syncswitch1", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
        state "synced", label: "Grp1 Synced", action: "unsyncAll", icon: "https://static.thenounproject.com/png/1821508-200.png", backgroundColor: "#79b821"
        state "unsynced", label: "Grp1 Unsynced", action: "syncG1", icon: "https://static.thenounproject.com/png/1821508-200.png", backgroundColor: "#ffffff"
        state "syncing", label: "Syncing", action: "unsyncAll", icon: "https://static.thenounproject.com/png/1821508-200.png", backgroundColor: "#79b821"
        state "unsyncing", label: "Unsyncing", action: "syncG1", icon: "https://static.thenounproject.com/png/1821508-200.png", backgroundColor: "#ffffff"
        }
        standardTile("syncGrp2", "device.syncswitch2", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
        state "synced", label: "Grp2 Synced", action: "unsyncAll", icon: "https://static.thenounproject.com/png/2178873-200.png", backgroundColor: "#79b821"
        state "unsynced", label: "Grp2 Unsynced", action: "syncG2", icon: "https://static.thenounproject.com/png/2178873-200.png", backgroundColor: "#ffffff"
        state "syncing", label: "Syncing", action: "unsyncAll", icon: "https://static.thenounproject.com/png/2178873-200.png", backgroundColor: "#79b821"
        state "unsyncing", label: "Unsyncing", action: "syncG2", icon: "https://static.thenounproject.com/png/2178873-200.png", backgroundColor: "#ffffff"
        }
        standardTile("syncGrp3", "device.syncswitch3", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
        state "synced", label: "Grp3 Synced", action: "unsyncAll", icon: "https://static.thenounproject.com/png/3254897-200.png", backgroundColor: "#79b821"
        state "unsynced", label: "Grp3 Unsynced", action: "syncG3", icon: "https://static.thenounproject.com/png/3254897-200.png", backgroundColor: "#ffffff"
        state "syncing", label: "Syncing", action: "unsyncAll", icon: "https://static.thenounproject.com/png/3254897-200.png", backgroundColor: "#79b821"
        state "unsyncing", label: "Unsyncing", action: "syncG3", icon: "https://static.thenounproject.com/png/3254897-200.png", backgroundColor: "#ffffff"
        }
        
         
        standardTile("playlistPicker", "device.picker", inactiveLabel: false, decoration: "flat") {
			state "up", action:"playlistPicker", icon:"https://static.thenounproject.com/png/2176957-200.png"
        }
        valueTile("playlist","device.playlist", height: 1, width: 5) {
            state "selectList", label:' playlist: ${currentValue}', defaultState: true
    	}
        standardTile("playerPicker", "device.picker", inactiveLabel: false, decoration: "flat") {
			state "up", action:"playerPicker", icon:"https://static.thenounproject.com/png/1732216-200.png"
        }
        valueTile("PlaylistPlayer","device.playlistPlayer", height: 1, width: 5) {
            state "selectPlayer", label:' Playlist player: ${currentValue}', defaultState: true
    	}
        standardTile("ApplyList", "device.playlistSender", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
        	state "apply", label: "Apply", action: "playlistApply", icon: "https://static.thenounproject.com/png/1599880-200.png", backgroundColor: "#79b821"
        	state "ready", label: "Apply", icon: "st.Entertainment.entertainment2", backgroundColor: "#ffffff"
        }
                    
       // The switch tile activates a DB scan - the interlock switch checks that this is the real action
       
 		standardTile("switch", "device.switch", decoration: "flat", width: 2, height: 2, canChangeIcon: false) {
        	state "on", label: 'Ready', action: "switch.off", icon: "https://static.thenounproject.com/png/735523-200.png", backgroundColor: "#3b48d9"
        	state "off", label: '${name}', action: "switch.on", icon: "https://static.thenounproject.com/png/735523-200.png", backgroundColor: "#ffffff"
        	state "scan",label: 'scan...', action: "switch.on", icon: "https://static.thenounproject.com/png/735523-200.png", backgroundColor: "#ff0000"
        	state "wait",label: 'wait', action: "switch.off", icon: "https://static.thenounproject.com/png/735523-200.png", backgroundColor: "#ff0000"
        }
        
        standardTile ("interlock", "device.interlock", decoration: "flat", width: 2, height: 2, canChangeIcon: false ){
        	state "locked", label: 'Scan', action:"unlock", icon: "https://static.thenounproject.com/png/721998-200.png", backgroundColor: "#ffffff"
            state "unlocked", label: 'Scan', action:"lock", icon: "https://static.thenounproject.com/png/821909-200.png", backgroundColor: "#ffffff"
        
        }
        valueTile("scanstate", "device.scanstate", height: 2, width: 4, inactiveLabel: false, canChangeBackground: true) {
            state "scanstate", label:'${currentValue}'//, icon: "st.Office.office5"
        }        
		standardTile("refresh", "device.switch", width: 2, height: 2, inactiveLabel: false, decoration: "flat") {
        	state "default", label:'', action:"refresh.refresh", icon:"https://static.thenounproject.com/png/15460-200.png"
        }
       
    } 

    main (["switch", "syncGrp1","syncGrp2","syncGrp3","playlistPicker","playlist","playerPicker","PlaylistPlayer","switch","interlock","refrsh","scanstate"])

}

//apply playlist ***********************************************************************

def playlistApply (){
	log.debug "send playlist"
    sendEvent (name:"ApplyList", value:"apply")
    sendcmd("${state.playerSelected}", "playlist play __playlists%2F${state.playlistSelected}")
    sendEvent (name:"ApplyList", value:"ready")
}

//handle pickers ***********************************************************************

def selectedList (text) {
	log.debug "selected list ${text}"
    sendEvent (name:"playlist", value:"${text}")
}

def selectedPlayer (text) {
	log.debug "selected player ${text}"
    sendEvent (name:"playlistPlayer", value:"${text}")
}
def playerPicker(){

//add players to a list
//declare in the correct scope
	if (state.playerIndex == NULL){
    	state.playerIndex =0
    }
	def count=0
    def playerList=[]
//find all playlists
    log.debug "Checking Player list"
	if (confp1){
        playerList << "1: "
    	playerList << confp1
        count++
    }
    if (confp2){
        playerList << "2: "
    	playerList << confp2
        count++
    }
    if (confp3){
    	playerList << "3: "
        playerList << confp3
        count++
    }
    if (confp4){
    	playerList << "4 :"
    	playerList << confp4
        count++
    }
        if (confp5){
    	playerList << "5 :"
    	playerList << confp5
        count++
    }
	if (count ==0){
    	log.debug " No players do nothing"
        selectedPlayer ("None")
        //sendEvent (name: "selected", value: "None")
        return -1
    }
	log.debug "Playlist has $count entries the index is ${state.playerIndex} $playerList"
    state.playerIndex=state.playerIndex+1
    if (state.playerIndex == count){
    	state.playerIndex=0
    }
    def index = 2 * state.playerIndex
    selectedPlayer("${playerList[index]} ${playerList[index+1]}")
 	state.playerSelected ="${playerList[index+1]}"
}

def playlistPicker(){

//add playlists to a list
//declare in the correct scope
	if (state.playlistIndex == NULL){
    	state.playlistIndex =0
    }
	def count=0
    def playListList=[]
//find all playlists
    log.debug "Checking Playlist list"
	if (playlist1){
    	playListList << playlist1
        count++
    }
    if (playlist2){
    	playListList << playlist2
        count++
    }
    if (playlist3){
    	playListList << playlist3
        count++
    }
    if (playlist4){
    	playListList << playlist4
        count++
    }
        if (playlist5){
    	playListList << playlist5
        count++
    }
	if (count ==0){
    	log.debug " No playlist do nothing"
        selectedList ("None")
        //sendEvent (name: "selected", value: "None")
        return -1
    }
	log.debug "Playlist has $count entries the index is ${state.playlistIndex} $playListList"
    state.playlistIndex=state.playlistIndex+1
    if (state.playlistIndex == count){
    	state.playlistIndex=0
    }
    selectedList("${playListList[state.playlistIndex]}")
 	state.playlistSelected = "${playListList[state.playlistIndex]}"
}
def pickerDown(){
}

//*******************************************************************************

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"

}
// function only used if command enabled at top
private String makeNetworkId(ipaddr, port) { 
	 String hexIp = ipaddr.tokenize('.').collect { 
     String.format('%02X', it.toInteger()) 
     }.join() 
     String hexPort = String.format('%04X', port()) 
     return "${hexIp}:${hexPort}" 
}



// function only used if command enabled at top
def getNID() {
	log.debug makeNetworkId("192.168.1.85", 9090) //your squeeze server CLI interface ip address and port
}

// handle commands for multiple players
def p1On(rsp)	{
	//log.debug settings.confp1
    sendcmd("${settings.confp1}", "play")
}
def p1Off()	{
	//log.debug settings.confp1
    sendcmd("${settings.confp1}", "pwroff") 
}
def p2On()	{
	//log.debug settings.confp2
    sendcmd("${settings.confp2}", "play")
}
def p2Off()	{
	//log.debug settings.confp2
    sendcmd("${settings.confp2}", "pwroff") 
}
def p3On()	{
	//log.debug settings.confp3
    sendcmd("${settings.confp3}", "play")
}
def p3Off()	{
	//log.debug settings.confp3
    sendcmd("${settings.confp3}", "pwroff") 
}
def p4On()	{
	//log.debug settings.confp4
    sendcmd("${settings.confp4}", "play")
}
def p4Off()	{
	//log.debug settings.confp4
        sendcmd("${settings.confp4}", "pwroff")
}
def p5On()	{
	//log.debug settings.confp5
    sendcmd("${settings.confp5}", "play")
}
def p5Off()	{
	//log.debug settings.confp5
    sendcmd("${settings.confp5}", "pwroff")  
}
// Added to restart server
def on() {
	log.debug "On"
    sendEvent (name: "switch", value: "On")

}

def off() {
// Always on //
	def value = device.currentValue("interlock")
    if (value == "locked"){
		//log.debug "Scan requested but locked"
        sendEvent (name: "scanstate", value: "Unlock to scan")
    } else {
    	//log.debug "Scan requested and unlocked"
        runIn(60,scanstatus)
        runIn(150,scanstatus, [overwrite: false]) // Some large scans can keep the server busy. So set a second check

        // below commented out for test
        sendHubCommand(new physicalgraph.device.HubAction("wipecache\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}")) // rescan only playlists
        sendEvent (name: "switch", value: "Wait")
        sendEvent (name: "scanstate", value: "Scan starting ...")
        //sendHubCommand(new physicalgraph.device.HubAction("rescan playlists\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}")) // rescan only playlists
	}
}

def unlock(){
	sendEvent (name: "interlock", value: "unlocked")
    runIn(5,lock)
}
def lock(){
	sendEvent (name: "interlock", value: "locked")
}

/*
// command for one player only
def on() {
	//log.debug "Executing 'on'"
    sendcmd("${settings.confp1}", "play")
}
def off() {
	//log.debug "Executing 'off'"
    sendcmd("${settings.confp1}", "pwroff")
}

*/
//handle refresh command ***********************************************************************

def p1refresh(){
	log.debug "Executing 'p1refresh'"
	sendcmd("${settings.confp1}", "mode ?")
}
def p2refresh(){
	log.debug "Executing 'p2refresh'"
    sendcmd("${settings.confp2}", "mode ?")
}
def p3refresh(){
	log.debug "Executing 'p3refresh'"
    sendcmd("${settings.confp3}", "mode ?")
}
def p4refresh(){
	log.debug "Executing 'p4refresh'"
    sendcmd("${settings.confp4}", "mode ?")
}
def p5refresh(){
	log.debug "Executing 'p5refresh'"
    sendcmd("${settings.confp5}", "mode ?")
}
def refresh() {
	//log.debug "Refresh"
    serverlistenon()
    scanstatus()
	//sendEvent (name: "refresh", value: "refresh")
    //sendEvent (name: "refresh", value: "done")
}


/*
//handles group refresh
def allrefresh(){
	//refresh all
    p1refresh()
    p2refresh()
    p3refresh()
    p4refresh()
    p5refresh()
}*/

//handle commands ***********************************************************************
def p1Volup(){
	//log.debug "Player 1 Volume 'up'"
    sendcmd("${settings.confp1}", "mixer volume +5")
}
def p1Voldn(){
	//log.debug "Player 1 Volume 'dn'"
    sendcmd("${settings.confp1}", "mixer volume -5")
}
def p2Volup(){
	//log.debug "Player 2 Volume 'up'"
    sendcmd("${settings.confp2}", "mixer volume +5")
}
def p2Voldn(){
	//log.debug "Player 1 Volume 'dn'"
    sendcmd("${settings.confp2}", "mixer volume -5")
}
def p3Volup(){
	//log.debug "Player 3 Volume 'up'"
    sendcmd("${settings.confp3}", "mixer volume +5")
}
def p3Voldn(){
	//log.debug "Player 3 Volume 'dn'"
    sendcmd("${settings.confp3}", "mixer volume -5")
}
def p4Volup(){
	//log.debug "Player 4 Volume 'up'"
    sendcmd("${settings.confp4}", "mixer volume +5")
}
def p4Voldn(){
	//log.debug "Player 4 Volume 'dn'"
    sendcmd("${settings.confp4}", "mixer volume -5")
}
def p5Volup(){
	//log.debug "Player 5 Volume 'up'"
    sendcmd("${settings.confp5}", "mixer volume +5")
}
def p5Voldn(){
	//log.debug "Player 5 Volume 'dn'"
    sendcmd("${settings.confp5}", "mixer volume -5")
}

//handle sync commands *************************************************************************

def syncG1(){
	log.debug " in syncG1"
	sendEvent (name: "syncswitch1", value: "syncing")
//declare in the correct scope
	def count=0
    def playerList=[]
//find master player and get MAC ADDRESS
    log.debug "Checking group 1"
	if (syc1play1){
    	if (syc1play1=="player 1"){
    		playerList << settings.confp1
    	}else if (syc1play1=="player 2"){
    		playerList << settings.confp2
    	}else if (syc1play1=="player 3"){
    		playerList << settings.confp3
    	}else if (syc1play1=="player 4"){
    		playerList << settings.confp4
    	}else if (syc1play1=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No master player set for group1 - stopped"
        sendEvent (name: "syncswitch1", value: "unsynced")
        return -1
    }
    if (syc1play2){
    	if (syc1play2=="player 1"){
    		playerList << settings.confp1
    	}else if (syc1play2=="player 2"){
    		playerList << settings.confp2
    	}else if (syc1play2=="player 3"){
    		playerList << settings.confp3
    	}else if (syc1play2=="player 4"){
    		playerList << settings.confp4
    	}else if (syc1play2=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No second player set for group1"
    }
    if (syc1play3){
    	if (syc1play3=="player 1"){
    		playerList << settings.confp1
    	}else if (syc1play3=="player 2"){
    		playerList << settings.confp2
    	}else if (syc1play3=="player 3"){
    		playerList << settings.confp3
    	}else if (syc1play3=="player 4"){
    		playerList << settings.confp4
    	}else if (syc1play3=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No third player set for group1"
    }
    if (syc1play4){
    	if (syc1play4=="player 1"){
    		playerList << settings.confp1
    	}else if (syc1play4=="player 2"){
    		playerList << settings.confp2
    	}else if (syc1play4=="player 3"){
    		playerList << settings.confp3
    	}else if (syc1play4=="player 4"){
    		playerList << settings.confp4
    	}else if (syc1play4=="player 5"){
    		playerList << settings.confp5
    	}
        count++
  	}else {
    	log.debug " No forth player set for group1"
    }
    if (syc1play5){
    	if (syc1play5=="player 1"){
    		playerList << settings.confp1
    	}else if (syc1play5=="player 2"){
    		playerList << settings.confp2
    	}else if (syc1play5=="player 3"){
    		playerList << settings.confp3
    	}else if (syc1play5=="player 4"){
    		playerList << settings.confp4
    	}else if (syc1play5=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No fifth player set for group1"
    }
    // check we have enough players at least 2 (zero and one)
    if (count <2){
        log.debug " Only one player found in group - stopped"
        sendEvent (name: "syncswitch1", value: "unsynced")
        return -1
    } 
    log.debug "Checking complete"
    syncGroup(playerList,count)
    sendEvent (name: "syncswitch1", value: "synced")
    log.debug "Group 1 all Synced"
}

// Constructs the Sync command for a group*************************************************
	def syncGroup(playerList,count){
    //log.debug "$playerList"
    log.debug "Group 1:${playerList[0]}, ${playerList[1]}, ${playerList[2]}, ${playerList[3]}, ${playerList[4]}"
    log.debug "$count"
    // turn on master player ... needs to have a curent paylist
    // to do add cmd here to play a playlist.
    sendcmd("${playerList[0]}","play")
    //delay (20)
    while (count>1){
    	count--
        //log.debug "${playerList[0]} sync ${playerList[count]}"
        // turn on player to sync
        sendcmd("${playerList[count]}","play")
        // sync player with master player
    	sendcmd("${playerList[0]}", "sync ${playerList[count]}")
        //delay(20)
    }
}
/*********************************************************************************************************/
def syncG2(){
	log.debug " in syncG2"
    	sendEvent (name: "syncswitch2", value: "syncing")
//declare in the correct scope
	def count=0
    def playerList=[]
//find master player and get MAC ADDRESS
	if (syc2play1){
    	if (syc2play1=="player 1"){
    		playerList << settings.confp1
    	}else if (syc2play1=="player 2"){
    		playerList << settings.confp2
    	}else if (syc2play1=="player 3"){
    		playerList << settings.confp3
    	}else if (syc2play1=="player 4"){
    		playerList << settings.confp4
    	}else if (syc2play1=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No master player set for group2 - stopped"
        sendEvent (name: "syncswitch2", value: "unsynced")
        return -1
    }
    if (syc2play2){
    	if (syc2play2=="player 1"){
    		playerList << settings.confp1
    	}else if (syc2play2=="player 2"){
    		playerList << settings.confp2
    	}else if (syc2play2=="player 3"){
    		playerList << settings.confp3
    	}else if (syc2play2=="player 4"){
    		playerList << settings.confp4
    	}else if (syc2play2=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No second player set for group2"
    }
    if (syc2play3){
    	if (syc2play3=="player 1"){
    		playerList << settings.confp1
    	}else if (syc2play3=="player 2"){
    		playerList << settings.confp2
    	}else if (syc2play3=="player 3"){
    		playerList << settings.confp3
    	}else if (syc2play3=="player 4"){
    		playerList << settings.confp4
    	}else if (syc2play3=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No third player set for group2"
    }
    if (syc2play4){
    	if (syc2play4=="player 1"){
    		playerList << settings.confp1
    	}else if (syc2play4=="player 2"){
    		playerList << settings.confp2
    	}else if (syc2play4=="player 3"){
    		playerList << settings.confp3
    	}else if (syc2play4=="player 4"){
    		playerList << settings.confp4
    	}else if (syc2play4=="player 5"){
    		playerList << settings.confp5
    	}
        count++
  	}else {
    	log.debug " No forth player set for group2"
    }
    if (syc2play5){
    	if (syc2play5=="player 1"){
    		playerList << settings.confp1
    	}else if (syc2play5=="player 2"){
    		playerList << settings.confp2
    	}else if (syc2play5=="player 3"){
    		playerList << settings.confp3
    	}else if (syc2play5=="player 4"){
    		playerList << settings.confp4
    	}else if (syc2play5=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No fifth player set for group2"
    }
    // check we have enough players at least 2 (zero and one)
    if (count <2){
        log.debug " Only one player found in group - stopped"
        sendEvent (name: "syncswitch2", value: "unsynced")
        return -1
    }
    syncGroup(playerList,count)
    sendEvent (name: "syncswitch2", value: "synced")
    log.debug "Group 2 all Synced"
}
//***************************************************************************************
def syncG3(){
	log.debug " in syncG3"
    sendEvent (name: "syncswitch3", value: "syncing")
//declare in the correct scope
	def count=0
    def playerList=[]
//find master player and get MAC ADDRESS
	if (syc3play1){
    	if (syc3play1=="player 1"){
    		playerList << settings.confp1
    	}else if (syc3play1=="player 2"){
    		playerList << settings.confp2
    	}else if (syc3play1=="player 3"){
    		playerList << settings.confp3
    	}else if (syc3play1=="player 4"){
    		playerList << settings.confp4
    	}else if (syc3play1=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No master player set for group3 - stopped"
        sendEvent (name: "syncswitch3", value: "unsynced")
        return -1
    }
    if (syc1play2){
    	if (syc3play2=="player 1"){
    		playerList << settings.confp1
    	}else if (syc3play2=="player 2"){
    		playerList << settings.confp2
    	}else if (syc3play2=="player 3"){
    		playerList << settings.confp3
    	}else if (syc3play2=="player 4"){
    		playerList << settings.confp4
    	}else if (syc3play2=="player 5"){
    		playerList << settings.confp5
        }
        count++
    }else {
    	log.debug " No second player set for group2"
    }
    if (syc3play3){
    	if (syc1play3=="player 1"){
    		playerList << settings.confp1
    	}else if (syc3play3=="player 2"){
    		playerList << settings.confp2
    	}else if (syc3play3=="player 3"){
    		playerList << settings.confp3
    	}else if (syc3play3=="player 4"){
    		playerList << settings.confp4
    	}else if (syc3play3=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No third player set for group3"
    }
    if (syc3play4){
    	if (syc3play4=="player 1"){
    		playerList << settings.confp1
    	}else if (syc3play4=="player 2"){
    		playerList << settings.confp2
    	}else if (syc3play4=="player 3"){
    		playerList << settings.confp3
    	}else if (syc3play4=="player 4"){
    		playerList << settings.confp4
    	}else if (syc3play4=="player 5"){
    		playerList << settings.confp5
    	}
        count++
  	}else {
    	log.debug " No forth player set for group3"
    }
    if (syc3play5){
    	if (syc3play5=="player 1"){
    		playerList << settings.confp1
    	}else if (syc3play5=="player 2"){
    		playerList << settings.confp2
    	}else if (syc3play5=="player 3"){
    		playerList << settings.confp3
    	}else if (syc3play5=="player 4"){
    		playerList << settings.confp4
    	}else if (syc3play5=="player 5"){
    		playerList << settings.confp5
    	}
        count++
    }else {
    	log.debug " No fifth player set for group3"
    }
    // check we have enough players at least 2 (zero and one)
    if (count <2){
        log.debug " Only one player found in group - stopped"
        sendEvent (name: "syncswitch3", value: "unsynced")
        return -1
    }
    syncGroup(playerList,count)
    sendEvent (name: "syncswitch3", value: "synced")
    log.debug "Group 3 all Synced"

}
def unsyncAll(){
	log.debug " in unsyncAll"
    
    // TO DO currently unsyncs all- a bit anoying if there are several groups defined.
    
    sendcmd("${settings.confp1}", "unsync")
    sendcmd("${settings.confp2}", "unsync")
    sendcmd("${settings.confp3}", "unsync")
    sendcmd("${settings.confp4}", "unsync")
    sendcmd("${settings.confp5}", "unsync")
    
    sendcmd("${settings.confp1}", "pwroff")
    sendcmd("${settings.confp2}", "pwroff")
    sendcmd("${settings.confp3}", "pwroff")
    sendcmd("${settings.confp4}", "pwroff")
    sendcmd("${settings.confp5}", "pwroff")
    
    sendEvent (name: "syncswitch1", value: "unsynced")
    sendEvent (name: "syncswitch2", value: "unsynced")
    sendEvent (name: "syncswitch3", value: "unsynced")

}

// handle responses from srever *********************************************************************************
	
def SBSResp (response){
	// log.debug "Server Response $response"
    // strip the %3A
    def rsp=response.replaceAll ('%3A',':')
    //log.debug "Server Response $rsp"
    
    // remove trailing characters
    def strlength=rsp.length()-3
    // log.debug "length is $strlength"
    rsp=rsp[0..strlength]
    log.debug "Modified response is:${rsp}"
    // Try to match sync reply //
    if(rsp.indexOf("sync")>=0){
    	//log.debug "sync from SBS"
    	if (rsp.indexOf("sync -")>=0){
        	log.debug " here is a unsync: -->$rsp"
        } else {
            log.debug " here is a sync:  -->$rsp"
        }
    }
    
    // Try to find scanning progress
    if (rsp.indexOf("rescanprogress")>=0){
    	// log.debug "scan progress ${rsp}"
       if (rsp.indexOf("rescan:0") >=0){ // Scan stopped
        def value = device.currentValue("scanstate")
        if (value.indexOf("Scan time:") >=1){
        	value = "Scan done ${value}"
        } else {
        	value = "Scan done"
        }
        sendEvent (name: "scanstate", value: "${value}")
       	sendEvent (name: "switch", value: "On")
        // log.debug "scan progress finished"
       }
       if (rsp.indexOf("rescan:1") >=1){ // Scanning
       def time = ""
       	if (rsp.indexOf("totaltime:")>=1) { // fines scan time
        	def start = rsp.indexOf("totaltime:")+ 10
        	def end = rsp.length()-1
            // log.debug "[${start}..${end}]"
        	time = rsp[start..end]
        	sendEvent (name: "scanstate", value: "Scan time: ${time}...")
            sendEvent (name: "switch", value: "scan")
            // log.debug "scan progress ongoing"
            runIn(60,scanstatus)
        }
       }        
    }
    
    // Try to match a MAC address of a player.
    // check MAC address is at start of command 'indexOf' returns the index of one string in another =-1 if not present. 
    // check play commands first 'MAC play', 'MAC mode play', 'MAC power 1', 'MAC pause 0'
    def compare1 = "${confp1} play "
    def compare2 = "${confp1} mode play"
    def compare3 = "${confp1} power 1"
    def compare4 = "${confp1} pause 0"
    def check1 = rsp.indexOf("$compare1")>-1
    def check2 = rsp.indexOf("$compare2")>-1
    def check3 = rsp.indexOf("$compare3")>-1
    def check4 = rsp.indexOf("$compare4")>-1
    //log.debug "$compare1: $check1 $compare2: $check2"
    if ((check1)||(check2)||(check3)||(check4)){
      	//log.debug " sqVS1 play detected"
        // Remove the MAC address and command in one.
        //rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS1:play"
        sendEvent (name: "p1response", value:"play")
        //log.debug "Modified response is:${rsp} <--"
    }
    compare1 = "${confp2} play "
    compare2 = "${confp2} mode play"
    compare3 = "${confp2} power 1"
    compare4 = "${confp2} pause 0"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS2:play"
        sendEvent (name: "p2response", value:"play")
    }
    compare1 = "${confp3} play "
    compare2 = "${confp3} mode play"
    compare3 = "${confp3} power 1"
    compare4 = "${confp3} pause 0"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS3:play"
        sendEvent (name: "p3response", value:"play")
    }
    compare1 = "${confp4} play "
    compare2 = "${confp4} mode play"
    compare3 = "${confp4} power 1"
    compare4 = "${confp4} pause 0"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS4:play"
        sendEvent (name: "p4response", value:"play")
    }
    compare1 = "${confp5} play "
    compare2 = "${confp5} mode play"
    compare3 = "${confp5} power 1"
    compare4 = "${confp5} pause 0"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS5:play"
        sendEvent (name: "p5response", value:"play")
    }
    // check power off next
    // check commands  'MAC stop', 'MAC mode stop', 'MAC power 0', 'MAC pause 1'
    compare1 = "${confp1} power 0 "
    compare2 = "${confp1} mode stop"
    compare3 = "${confp1} stop"
    compare4 = "${confp1} pause 1"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS1:power off "
        sendEvent (name: "p1response", value:"power 0")
    }
    compare1 = "${confp2} power 0 "
    compare2 = "${confp2} mode stop"
    compare3 = "${confp2} stop"
    compare4 = "${confp2} pause 1"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS2:power off "
        sendEvent (name: "p2response", value:"power 0")
    }
    compare1 = "${confp3} power 0 "
    compare2 = "${confp3} mode stop"
    compare3 = "${confp3} stop"
    compare4 = "${confp3} pause 1"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS3:power off "
        sendEvent (name: "p3response", value:"power 0")
    }
    compare1 = "${confp4} power 0 "
    compare2 = "${confp4} mode stop"
    compare3 = "${confp4} stop"
    compare4 = "${confp4} pause 1"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS4:power off "
        sendEvent (name: "p4response", value:"power 0")
    }
    compare1 = "${confp5} power 0 "
    compare2 = "${confp5} mode stop"
    compare3 = "${confp5} stop"
    compare4 = "${confp5} pause 1"
    check1 = rsp.indexOf("$compare1")>-1
    check2 = rsp.indexOf("$compare2")>-1
    check3 = rsp.indexOf("$compare3")>-1
    check4 = rsp.indexOf("$compare4")>-1
    if ((check1)||(check2)||(check3)||(check4)){
    	//rsp= rsp.replaceAll(compare1,'')
        //rsp= rsp.replaceAll(compare2,'')
        log.debug "Reply from SqVS5:power off "
        sendEvent (name: "p5response", value:"power 0")
    }
}
// creates and sends the commans to the SBS
def sendcmd(playerID,command){
	log.debug "command to send -->$playerID $command"
    
    if (command=="pwroff"){
    	// soft off
    	command = "power 0"
    }
    if (command=="play") {
    	//log.debug " in play"
    	command ="play"
    }
    if (command=="unsync") {
    	//log.debug " in unsync"
    	command ="sync -"
    }
   	sendHubCommand(new physicalgraph.device.HubAction("${playerID} ${command}\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))
    return 1
}

def scanstatus(){
	log.debug "check scan"
	 sendHubCommand(new physicalgraph.device.HubAction("rescanprogress\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))// rescan progress
}
def serverlistenon ()
{
	//sendHubCommand(new physicalgraph.device.HubAction("listen 1\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))// listen to server activity
    sendHubCommand(new physicalgraph.device.HubAction("subscribe power,pause,mode\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))// listen for power mode and pause activity
}
def serverlistenoff ()
{
	//sendHubCommand(new physicalgraph.device.HubAction("listen 0\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))// stop listening to server activity
	sendHubCommand(new physicalgraph.device.HubAction("subscribe\r\n\r\n",physicalgraph.device.Protocol.LAN, "${device.deviceNetworkId}"))// stop listening for activity
}


def delay(factor){
    if (factor>50){
    	factor =50
    }
    def delay =1000*factor
    while (delay>0){
    delay--
	}
}