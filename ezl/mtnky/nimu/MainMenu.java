package ezl.mtnky.nimu;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.client.GuiModList;

public class MainMenu extends GuiScreen {
   public static boolean MainTheme = true;

   public void initGui() {
      int j = this.height / 4 + 48;
      this.buttonList.add(new GuiButton(242, this.width / 2 - 100, j + 72 + 12, I18n.format("menu.options", new Object[0])));
      this.buttonList.add(new GuiButton(240, this.width / 2 - 100, j - 44, I18n.format("menu.singleplayer", new Object[0])));
      this.buttonList.add(new GuiButton(241, this.width / 2 - 100, j + 24 - 44, I18n.format("menu.multiplayer", new Object[0])));
      this.buttonList.add(new GuiButton(6, this.width / 2 - 100, j + 48, 98, 20, I18n.format("fml.menu.mods", new Object[0])));
      this.buttonList.add(new GuiButton(244, this.width / 2 + 2, j + 48, 98, 20, "Theme: nimu"));
      super.initGui();
   }

   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      this.mc.getTextureManager().bindTexture(new ResourceLocation("client/background.png"));
      drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, this.width, this.height, (float)this.width, (float)this.height);
      super.drawScreen(mouseX, mouseY, partialTicks);
   }

   protected void actionPerformed(GuiButton button) throws IOException {
      if (button.id == 5) {
         this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
      }

      if (button.id == 6) {
         this.mc.displayGuiScreen(new GuiModList(this));
      }

      if (button.id == 240) {
         this.mc.displayGuiScreen(new GuiSelectWorld(this));
      }

      if (button.id == 241) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (button.id == 242) {
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
      }

      if (button.id == 243) {
         this.mc.shutdown();
      }

      if (button.id == 244) {
         MainTheme = !MainTheme;
      }

      super.actionPerformed(button);
   }

   public static class MainMenuTwo extends GuiMainMenu {
      public void initGui() {
         super.initGui();
         this.buttonList.add(new GuiButton(3141592, this.width / 2 - 100, this.height / 4 + 160, "Theme: normal"));
      }

      protected void actionPerformed(GuiButton button) {
         if (button.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
         }

         if (button.id == 5) {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
         }

         if (button.id == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
         }

         if (button.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
         }

         if (button.id == 4) {
            this.mc.shutdown();
         }

         if (button.id == 6) {
            this.mc.displayGuiScreen(new GuiModList(this));
         }

         if (button.id == 11) {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
         }

         if (button.id == 12) {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");
            if (worldinfo != null) {
               GuiYesNo guiyesno = GuiSelectWorld.makeDeleteWorldYesNo(this, worldinfo.getWorldName(), 12);
               this.mc.displayGuiScreen(guiyesno);
            }
         }

         if (button.id == 3141592) {
            MainMenu.MainTheme = !MainMenu.MainTheme;
         }

      }
   }
}
