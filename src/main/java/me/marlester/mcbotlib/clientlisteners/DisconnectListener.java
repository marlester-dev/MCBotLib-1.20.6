/*
 *
 * Copyright (C) 2024 Marlester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package me.marlester.mcbotlib.clientlisteners;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import me.marlester.mcbotlib.Bot;
import org.geysermc.mcprotocollib.network.event.session.DisconnectedEvent;
import org.geysermc.mcprotocollib.network.event.session.SessionAdapter;

@RequiredArgsConstructor
public class DisconnectListener extends SessionAdapter {
  private static final Logger LOG = Logger.getLogger(DisconnectListener.class.getName());

  private final Bot bot;

  @Override
  public void disconnected(DisconnectedEvent event) {
    var cause = event.getCause();
    if (cause != null && bot.getSettings().isLogDisconnectErrors()) {
      LOG.log(Level.SEVERE, "Bot " + bot.getNick() + " disconnected with an error!", cause);
    }
  }
}
