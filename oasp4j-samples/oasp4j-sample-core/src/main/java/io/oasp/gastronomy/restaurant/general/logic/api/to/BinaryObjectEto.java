package io.oasp.gastronomy.restaurant.general.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.BinaryObject;
import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;

import java.sql.Blob;

/**
 * The {@link io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto ETO} for a {@link BinaryObject}.
 *
 * @author sspielma
 */
public class BinaryObjectEto extends AbstractEto implements BinaryObject {

  private static final long serialVersionUID = 1L;

  private String mimeType;

  private Blob data;

  private long size;

  /**
   * Constructor.
   */
  public BinaryObjectEto() {

    super();
  }

  @Override
  public void setMimeType(String mimeType) {

    this.mimeType = mimeType;

  }

  @Override
  public String getMimeType() {

    return this.mimeType;
  }

  @Override
  public long getSize() {

    return this.size;
  }

  @Override
  public void setSize(long size) {

    this.size = size;
  }

  @Override
  public Blob getData() {
    return this.data;
  }

  @Override
  public void setData(Blob data) {

    this.data = data;
  }


}
