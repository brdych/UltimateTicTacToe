package ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import ultimatetictactoe.UltimateTicTacToeClient;

public class Menu extends javax.swing.JPanel
{
    private final JScrollPane p,l;
    private final JPanel pView,lView;
    private final UltimateTicTacToeClient game;
    
    public Menu(UltimateTicTacToeClient game)
    {
        initComponents();
        this.game = game;
        
        pView = new JPanel();
        pView.setLayout(new GridLayout(0,1));
        p = new JScrollPane(pView);
        openGamesPanel.add(p);
        
        lView = new JPanel();
        lView.setLayout(new GridLayout(0,1));
        l = new JScrollPane(lView);
        leaderBoardPanel.add(l);
        
        openGames(UltimateTicTacToeClient.getProxy().showAllMyGames(game.getUserID()+""));
        openGames(UltimateTicTacToeClient.getProxy().showMyOpenGames(game.getUserID()));
    }
    
    public JTabbedPane getPane()
    {
        return TabbedPane;
    }
    
    public void joinGame(int gid, OpenGame clicked, String hostName)
    {
        pView.remove(clicked);
        String result = UltimateTicTacToeClient.getProxy().joinGame(game.getUserID(), gid);
        switch(result)
        {
            case"0":
            case"ERROR-DB":
                game.alertUser("Oops!\nDatabase Error!");
                break;
            default:
                addGame(gid+"",hostName);
        }
    }
    
    private ArrayList<ArrayList<String>> gamesToArray(String games)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String[] temp = games.split("\n");
        for (String csv : temp)
        {
            ArrayList<String> items = new ArrayList<>(Arrays.asList(csv.split(",")));
            result.add(items);
        }
        return result;
    }
    
    private void openGames(String games)
    {
        switch(games)
        {
            case"ERROR-NOGAMES":
                break;
            case"ERROR-DB":
                game.alertUser("Oops!\nDatabase Error!");
                break;
            default:
                ArrayList<ArrayList<String>> allGames = gamesToArray(games);
                allGames.forEach((items) ->
                {
                    int gid = Integer.parseInt(items.get(0));
                    int gs = Integer.parseInt(UltimateTicTacToeClient.getProxy().getGameState(gid));
                    if (gs<1)
                    {
                        addGame(items.get(0),items.get(1));
                    }
                });
        }
    }
    
    private void addGame(String gameKey,String hostID)
    {
        switch(gameKey)
        {
            case"ERROR-NOTFOUND":
            case"ERROR-RETRIEVE":
            case"ERROR-INSERT":
            case"ERROR-DB":
            case"0":
                game.alertUser("Oops!\nDatabase Error!");
                break;
            default:
                GamePanel newgame = new GamePanel(game,Integer.parseInt(gameKey),hostID,this);
                this.TabbedPane.addTab(gameKey, null, newgame);
                TabbedPane.setSelectedIndex(TabbedPane.indexOfTab(gameKey));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        OpenGames = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        blankPanel = new javax.swing.JPanel();
        openGamesPanel = new javax.swing.JPanel();
        NewGameButton = new javax.swing.JButton();
        LeaderBoard = new javax.swing.JPanel();
        leaderBoardPanel = new javax.swing.JPanel();
        refreshLeaderboardBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.GridLayout(1, 2));

        OpenGames.setPreferredSize(new java.awt.Dimension(512, 256));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout blankPanelLayout = new javax.swing.GroupLayout(blankPanel);
        blankPanel.setLayout(blankPanelLayout);
        blankPanelLayout.setHorizontalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        blankPanelLayout.setVerticalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        openGamesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Games"));
        openGamesPanel.setLayout(new java.awt.GridLayout(0, 1));

        NewGameButton.setText("New Game");
        NewGameButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                NewGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OpenGamesLayout = new javax.swing.GroupLayout(OpenGames);
        OpenGames.setLayout(OpenGamesLayout);
        OpenGamesLayout.setHorizontalGroup(
            OpenGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpenGamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openGamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OpenGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blankPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        OpenGamesLayout.setVerticalGroup(
            OpenGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpenGamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OpenGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openGamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(OpenGamesLayout.createSequentialGroup()
                        .addComponent(blankPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(NewGameButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );

        TabbedPane.addTab("Games", OpenGames);

        leaderBoardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("LeaderBoard"));
        leaderBoardPanel.setLayout(new java.awt.GridLayout(0, 1));

        refreshLeaderboardBtn.setText("Refresh");
        refreshLeaderboardBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                refreshLeaderboardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeaderBoardLayout = new javax.swing.GroupLayout(LeaderBoard);
        LeaderBoard.setLayout(LeaderBoardLayout);
        LeaderBoardLayout.setHorizontalGroup(
            LeaderBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaderBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeaderBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leaderBoardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshLeaderboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addContainerGap())
        );
        LeaderBoardLayout.setVerticalGroup(
            LeaderBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaderBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leaderBoardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshLeaderboardBtn)
                .addContainerGap())
        );

        TabbedPane.addTab("Leaderboard", LeaderBoard);

        add(TabbedPane);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshButtonActionPerformed
    {//GEN-HEADEREND:event_refreshButtonActionPerformed
        String result = UltimateTicTacToeClient.getProxy().showOpenGames();
        String mine = UltimateTicTacToeClient.getProxy().showMyOpenGames(game.getUserID());
        switch(result)
        {
            case "ERROR-NOGAMES":
                pView.removeAll();
                pView.add(new JLabel("No games!"));
                pView.revalidate();
                break;
            case "ERROR-DB":
                    game.alertUser("Oops!\nError connecting to database!");
                break;
            default:
                pView.removeAll();
                ArrayList<ArrayList<String>> results = gamesToArray(result);
                if(!(mine.equals("ERROR-NOGAMES"))&&!(mine.equals("DB-ERROR")))
                {
                    ArrayList<ArrayList<String>> mines = gamesToArray(mine);
                    results.removeAll(mines);
                }
                results.forEach((s) ->
                {
                    pView.add(new OpenGame(s.get(0),s.get(1),this));
                });
                pView.revalidate();
        } 
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void NewGameButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_NewGameButtonActionPerformed
    {//GEN-HEADEREND:event_NewGameButtonActionPerformed
        addGame(UltimateTicTacToeClient.getProxy().newGame(game.getUserID()),game.getUserName());
    }//GEN-LAST:event_NewGameButtonActionPerformed

    private void refreshLeaderboardBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshLeaderboardBtnActionPerformed
    {//GEN-HEADEREND:event_refreshLeaderboardBtnActionPerformed
        String leaderBoard = UltimateTicTacToeClient.getProxy().leagueTable();
        switch(leaderBoard)
        {
            case"ERROR-NOGAMES":
                break;
            case"ERROR-DB":
                game.alertUser("Oops!\nDatabase Error!");
                break;
            default:
                HashMap<String,int[]> usersToScores = new HashMap<>();
                lView.removeAll();
                lView.add(new LeaderBoardEntry());
                ArrayList<ArrayList<String>> results = gamesToArray(leaderBoard);
                results.forEach((a) ->
                {
                    if(!(a.get(3).equals("0")))
                    {
                        int victor = Integer.parseInt(a.get(3));
                        if(!usersToScores.containsKey(a.get(1)))
                            usersToScores.put(a.get(1), new int[3]);
                        if(!usersToScores.containsKey(a.get(2)))
                            usersToScores.put(a.get(2), new int[3]);

                        if(victor == 3)
                        {
                            usersToScores.get(a.get(1))[2]++;
                            usersToScores.get(a.get(2))[2]++;
                        }
                        else
                        {
                            int loser = (victor==1)?2:1;
                            usersToScores.get(a.get(victor))[0]++;
                            usersToScores.get(a.get(loser))[1]++;
                        }
                    }
                });
                
                for (String key : usersToScores.keySet()) 
                {
                    int score = usersToScores.get(key)[0];
                    int loss = usersToScores.get(key)[1];
                    int draw = usersToScores.get(key)[2];
                    lView.add(new LeaderBoardEntry(key,score,loss,draw));
                }
                lView.revalidate();
        }
    }//GEN-LAST:event_refreshLeaderboardBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeaderBoard;
    private javax.swing.JButton NewGameButton;
    private javax.swing.JPanel OpenGames;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel blankPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel leaderBoardPanel;
    private javax.swing.JPanel openGamesPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshLeaderboardBtn;
    // End of variables declaration//GEN-END:variables
}
