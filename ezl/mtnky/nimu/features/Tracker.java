package ezl.mtnky.nimu.features;

import java.io.IOException;
import java.time.Instant;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Tracker {
   private boolean a;
   private boolean ig;
   private boolean ag;

   public static String getSidebarTitle() {
      Minecraft mc = Minecraft.getMinecraft();
      if (mc.theWorld != null && mc.theWorld.getScoreboard() != null) {
         Scoreboard scoreboard = mc.theWorld.getScoreboard();
         ScoreObjective sidebarObjective = scoreboard.getObjectiveInDisplaySlot(1);
         if (sidebarObjective != null) {
            return sidebarObjective.getDisplayName();
         }
      }

      return null;
   }

   @SubscribeEvent
   public void QueueTracking(ClientChatReceivedEvent e) {
      String A = e.message.getUnformattedText().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "");
      if (Minecraft.getMinecraft().thePlayer.getName() == "2muu") {
         sendWebhook2("``" + A + "``");
      }

      long unixTimestamp = Instant.now().getEpochSecond();
      String discordTimestamp = "<t:" + unixTimestamp + ":R>";
      if (getSidebarTitle() != null) {
         String ax = Minecraft.getMinecraft().thePlayer.getName().equalsIgnoreCase(Minecraft.getMinecraft().thePlayer.getDisplayNameString()) ? "``" + Minecraft.getMinecraft().thePlayer.getName() + "``" : "``" + Minecraft.getMinecraft().thePlayer.getName() + "`` (``" + Minecraft.getMinecraft().thePlayer.getDisplayNameString() + "``)";
         if (getSidebarTitle().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "").contains("BED WARS")) {
            if (!A.contains("lobby") && A.contains(Minecraft.getMinecraft().thePlayer.getName() + " has joined") || A.contains(" has joined") && Minecraft.getMinecraft().thePlayer.getName() == "2muu") {
               this.a = true;
               if (this.ig) {
                  sendWebhook(":yellow_circle: ``" + Minecraft.getMinecraft().thePlayer.getName() + "`` (``" + Minecraft.getMinecraft().thePlayer.getDisplayNameString() + "``) Re-queued!" + discordTimestamp);
               }

               Minecraft.getMinecraft().thePlayer.sendChatMessage("/wtfmap");
               this.ig = true;
            }

            if (A.matches("You are currently playing on \\w+")) {
               if (!this.a) {
                  return;
               }

               this.a = false;
               sendWebhook(":green_circle: " + ax + " queued ``" + A.split(" ")[5] + "`` " + discordTimestamp);
            }

            if (A.contains("Protect your bed and destroy the enemy beds.")) {
               sendWebhook(":red_circle: " + ax + "'s game started! " + discordTimestamp);
               this.ag = true;
            }

            if (A.contains("Bed Wars") && !A.contains(":")) {
               if (this.ag) {
                  sendWebhook(":blue_circle: " + ax + "'s game ended!" + discordTimestamp);
               }

               this.ag = false;
               this.ig = false;
            }
         } else if (getSidebarTitle().replaceAll("§([0-9a-f]|r|l|o|n|m|k)", "").contains("DUELS")) {
            if (!A.contains("lobby") && A.contains(Minecraft.getMinecraft().thePlayer.getName() + " has joined") || A.contains(" has joined") && Minecraft.getMinecraft().thePlayer.getName() == "2muu") {
               this.a = true;
               if (this.ig) {
                  sendWebhook3(":yellow_circle: ``" + Minecraft.getMinecraft().thePlayer.getName() + "`` (``" + Minecraft.getMinecraft().thePlayer.getDisplayNameString() + "``) Re-queued!" + discordTimestamp);
               }

               Minecraft.getMinecraft().thePlayer.sendChatMessage("/wtfmap");
               this.ig = true;
            }

            if (A.matches("You are currently playing on \\w+")) {
               if (!this.a) {
                  return;
               }

               this.a = false;
               sendWebhook3(":green_circle: " + ax + " queued ``" + A.split(" ")[5] + "`` " + discordTimestamp);
            }

            if (A.contains("Eliminate your opponents!")) {
               sendWebhook3(":red_circle: " + ax + "'s game started! " + discordTimestamp);
               this.ag = true;
            }

            if (A.contains("Accuracy") && !A.contains(":")) {
               if (this.ag) {
                  sendWebhook3(":blue_circle: " + ax + "'s game ended!" + discordTimestamp);
               }

               this.ag = false;
               this.ig = false;
            }
         }

      }
   }

   public static void sendWebhook(String content) {
      OkHttpClient client = new OkHttpClient();
      String jsonPayload = "{\"content\":\"" + content + "\"}";
      RequestBody body = RequestBody.create(jsonPayload, MediaType.get("application/json"));
      Request request = (new Request.Builder()).url("https://discord.com/api/webhooks/1332925108276170875/cOjLLl9e2dkepZs05V4XNPPHox5cJFH84jayIPEzRHgAy--QQPyEQ9154ZV9N52nrriS").post(body).build();
      client.newCall(request).enqueue(new Callback() {
         public void onFailure(Call call, IOException e) {
            System.err.println("Ade=" + e.getMessage());
         }

         public void onResponse(Call call, Response response) throws IOException {
         }
      });
   }

   public static void sendWebhook2(String content) {
      OkHttpClient client = new OkHttpClient();
      String jsonPayload = "{\"content\":\"" + content + "\"}";
      RequestBody body = RequestBody.create(jsonPayload, MediaType.get("application/json"));
      Request request = (new Request.Builder()).url("https://discord.com/api/webhooks/1333040522108862534/3IbEAnXryyoULqnHnksiE33wefqFUKwnLLCwV5hte9_sxgWC402gpMJlQAeE_xHQoTyu").post(body).build();
      client.newCall(request).enqueue(new Callback() {
         public void onFailure(Call call, IOException e) {
            System.err.println("Ade=" + e.getMessage());
         }

         public void onResponse(Call call, Response response) throws IOException {
         }
      });
   }

   public static void sendWebhook3(String content) {
      OkHttpClient client = new OkHttpClient();
      String jsonPayload = "{\"content\":\"" + content + "\"}";
      RequestBody body = RequestBody.create(jsonPayload, MediaType.get("application/json"));
      Request request = (new Request.Builder()).url("https://discord.com/api/webhooks/1333203069843804261/lO1a1QbY264G52LExD-Z7b_5nXXjjXzI44uxHLKgZ1gSymSWEF2CwBqVzSP0RS-ekFov").post(body).build();
      client.newCall(request).enqueue(new Callback() {
         public void onFailure(Call call, IOException e) {
            System.err.println("Ade=" + e.getMessage());
         }

         public void onResponse(Call call, Response response) throws IOException {
         }
      });
   }
}
