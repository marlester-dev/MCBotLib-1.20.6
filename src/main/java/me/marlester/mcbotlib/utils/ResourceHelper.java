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

package me.marlester.mcbotlib.utils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ResourceHelper {
  private ResourceHelper() {}

  public static String getResource(String path) {
    return new String(getResourceBytes(path), StandardCharsets.UTF_8);
  }

  public static byte[] getResourceBytes(String path) {
    try {
      return Objects.requireNonNull(ResourceHelper.class.getResourceAsStream(path)).readAllBytes();
    } catch (Exception e) {
      throw new RuntimeException("Failed to get file", e);
    }
  }

  public static URL getResourceUrl(String path) {
    try {
      return Objects.requireNonNull(ResourceHelper.class.getResource(path));
    } catch (Exception e) {
      throw new RuntimeException("Failed to get file", e);
    }
  }
}
